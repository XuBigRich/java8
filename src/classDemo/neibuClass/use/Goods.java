package classDemo.neibuClass.use;

/**
 * 封装性
 * <p>
 * 在这个例子里类 Content 和 GDestination 被定义在了类 Goods 内部，
 * 并且分别有着 protected 和 private 修饰符来控制访问级别。
 * Content 代表着 Goods 的内容，而 GDestination 代表着 Goods 的目的地。
 * 它们分别实现了两个接口Content和Destination。在后面的main方法里，
 * 直接用 Contents c 和 Destination d进行操作，你甚至连这两个内部类的名字都没有看见！
 * 这样，内部类的第一个好处就体现出来了——隐藏你不想让别人知道的操作，也即封装性。
 */
public class Goods {
    private class Content implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class GDestination implements Destination {
        private String label;

        private GDestination(String whereTo) {
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }

    public class OuterClass{
        {
            System.out.println("我被创建");
        }
    }

    public Destination dest(String s) {
        return new GDestination(s);
    }

    public Contents cont() {
        return new Content();
    }
}

class TestGoods {
    public static void main(String[] args) {
        Goods p = new Goods();
        Contents c = p.cont();
        Destination d = p.dest("Beijing");
        //同时，我们也发现了在外部类作用范围之外得到内部类对象的第一个方法，
        // 那就是利用其外部类的方法创建并返回。上例中的cont()和 dest() 方法就是这么做的。
        // 那么还有没有别的方法呢？当然有，其语法格式如下：
        //此为protected内部类
//        p.new GDestination();
        //此为私有内部类
//        p.new Content();
        //此为公共内部类
        p.new OuterClass();
    }
}

