package classDemo.xiushifu;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName aaa.java
 * @Description 修饰符  一个类 只能由 一个 public 类 可以有多个 属于friendly作用域的类
 * 类只可以有 public 与riendly 两个 作用域  且 可以拥有最多一个public类
 *  内部类除了 public修饰符   都可以 修饰
 * @createTime 2019年04月17日 10:44:00
 */
public class Zuoyongfanwei {
    private int a;
    int b;
    protected int c;
    public int d;
    int e;

    public void a(){
        System.out.println("a");
    }

    protected void b() {
        System.out.println("b");
    }
    void c() {
        System.out.println("c");
    }
    private void d(){
        System.out.println("d");
    }
//=======================================
    private class Synbl{

    }
    protected class Pronbl{

    }
    class Mrnbl{

    }

//=======================================
}  //这个地方是Zuoyongfanwei类 的结束 括号
//===========================================
class A{   //这种类 只能在 本包中访问 属于friendly 作用域
    A(){
        System.out.println("a");
    }
}
class B{
    B(){
        System.out.println("b");
    }
}
//===========================================
