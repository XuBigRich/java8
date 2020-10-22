package classDemo.neibuClass.whyuse;

/**
 * 该类将解答内部类是如何实现多继承的
 * 一个内部类的可访问外部类的父类 与 外部类 与 内部类父类 与 本身的参数 与方法
 *
 * @Author： hongzhi.xu
 * @Date: 2020/10/21 3:02 下午
 * @Version 1.0
 */
public class Demo extends AParent {
    private String type = "学校";
    public String test = "test";

    public void demoMethod() {
        System.out.println("Demo");
    }

    class Demo2 extends BParent {
        private String name = "许鸿志";

        public Demo2() {
            //输出外部类父类参数，外部类参数，内部类参数，内部类父类参数
            System.out.println(Demo.super.name + " " + type + " " + name + " " + sex);
        }

        public void demo2Method() {
            System.out.println("Demo2");
        }

        public String getType() {
            return type;
        }

        public void allMethod() {
            demo2Method();
            demoMethod();
            super.bParentMethod();
            Demo.super.aParentMethod();
        }
    }

    public static void main(String[] args) {
        Demo n = new Demo();
        Demo2 m = n.new Demo2();
        m.demo2Method();
        m.bParentMethod();
        System.out.println(m.name);
        System.out.println(m.sex);
        //通过对象访问是无法直接访问到这个内部类的外部类属性 与方法的
//        System.out.println(m.test);
        //可以通过其他方式如
        System.out.println(m.getType());
        m.allMethod();
    }
}
