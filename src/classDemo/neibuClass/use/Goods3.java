package classDemo.neibuClass.use;

/**
 * 静态内部类（嵌套类）
 * <p>
 * 和普通的类一样，内部类也可以有静态的。
 * 不过和非静态内部类相比，
 * 区别就在于静态内部类没有了指向外部的引用。
 * 这实际上和 C++ 中的嵌套类很相像了，
 * Java 内部类与 C++ 嵌套类最大的不同就在于是否有指向外部的引用这一点上
 * ，当然从设计的角度以及以它一些细节来讲还有区别。
 * 除此之外，在任何非静态内部类中，都不能有静态数据， 静态方法或者又一个静态内部类（内部类的嵌套可以不止一层）。
 * 不过静态内部类中却可以拥有这一切。这也算是两者的第二个区别吧。
 *
 *
 *   下面这个例子。在方法dest中我们定义了一个内部类，最后由这个方法返回这个内部类的对象。
 *   如果我们在用一个内部类的时候仅需要创建它的一个对象并传给外部，就可以这样做。
 *   当然，定义在方法中的内部类可以使设计多样化，用途绝不仅仅在这一点。
 * @Author： hongzhi.xu
 * @Date: 2020/10/21 10:55 上午
 * @Version 1.0
 */
public class Goods3 {
    public Destination dest(String s) {
        class GDestination implements Destination {
            private String label;

            private GDestination(String whereTo) {
                label = whereTo;
            }

            public String readLabel() {
                return label;
            }
        }

        return new GDestination(s);
    }

    public static void main(String[] args) {
        Goods3 g = new Goods3();
        Destination d = g.dest("Beijing");
    }

}
