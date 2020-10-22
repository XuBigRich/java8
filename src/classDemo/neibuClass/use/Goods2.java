package classDemo.neibuClass.use;

/**
 * 非静态内部类对象有着指向其外部类对象的引用
 *在这里我们给 Goods 类增加了一个 private 成员变量 valueRate，意义是货物的价值系数，
 * 在内部类 Content 的方法 value() 计算价值时把它乘上。我们发现，
 * value() 可以访问 valueRate，
 * 这也是内部类的第二个好处——一个内部类对象可以访问创建它的外部类对象的内容，甚至包括私有变量！
 * 这是一个非常有用的特性，为我们在设计时提供了更多的思路和捷径。
 * 要想实现这个功能，内部类对象就必须有指向外部类对象的引用
 * 。Java 编译器在创建内部类对象时，隐式的把其外部类对象的引用也传了进去并一直保存着。
 * 这样就使得内部类对象始终可以访问其外部类对象，同时这也是为什么在外部 类作用范围之外向要创建内部类对象必须先创建其外部类对象的原因。
 * （具体原因见：http://blog.csdn.net/yu422560654/article/details/6978981）
 *
 *  有人会问，如果内部类里的一个成员变量与外部类的一个成员变量同名，也即外部类 的同名成员变量被屏蔽了，怎么办？
 *  没事，Java里用如下格式表达外部类的引用：outerClass.this
 *   有了它，我们就不怕这种屏蔽的情况了。
 * @Author： hongzhi.xu
 * @Date: 2020/10/21 10:42 上午
 * @Version 1.0
 */
public class Goods2 {
    private int valueRate = 2;

    private class Content implements Contents {
        private int i = 11 * valueRate;

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

    public Destination dest(String s) {
        return new GDestination(s);
    }

    public Contents cont() {
        return new Content();
    }
}


