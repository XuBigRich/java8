package classDemo.xiushifu;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestMain.java
 * @Description TODO
 * @createTime 2019年04月17日 14:20:00
 */
public class TestMain {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        Zuoyongfanwei zuoyongfanwei=new Zuoyongfanwei();
        zuoyongfanwei.c=1;  //
        Zuoyongfanwei2 zuoyongfanwei2=new Zuoyongfanwei2(); //frendly类可以被本包访问
    }
    Zuoyongfanwei.Mrnbl zuoyongfanwei=new Zuoyongfanwei().new Mrnbl();
    Zuoyongfanwei.Pronbl pronbl=new Zuoyongfanwei().new Pronbl();
}
