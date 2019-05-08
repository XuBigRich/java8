package jicheng.mianshiti.duotai.jieshi;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JSSuperAThis.java
 * @Description 解释Super 与this
 * @createTime 2019年04月26日 11:39:00
 */

/*
* this是自身的一个对象，代表对象本身，可以理解为：指向对象本身的一个指针。
* super可以理解为是指向自己超（父）类的一个指针，而这个超类指的是离自己最近的一个父类  （注意非父类对象 因为只有一个对象）。
* */
public class JSSuperAThis {
    public static void main(String[] args) {
        C c=new C();
    }
    static class A{
        public void test(){
            System.out.println("a");
        }
    }
    static class B extends A{
        public B(){
            this.test();   //调用这个对象的 test方法 即   输出c
            super.test();  // 调用 超类 的 test方法  即输出 a    （注意区分，是所在类的超类，不是当前对象的超类（父类））
        }
        public void test(){
            System.out.println("b");
        }
    }
    static class C extends B{
        public C(){
            super();
        }
        public void test(){
            System.out.println("c");
        }
    }
}
