package classDemo.xiushifu2;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestZyfw2.java
 * @Description 说明 protected 只能在 本包 子类中 访问 其实是 与子类同一个 包中的类 也不可以访问
 * @createTime 2019年04月18日 18:10:00
 */
public class TestZyfw2 {
    public static void main(String[] args) {
        TestZyfw testZyfw=new TestZyfw();
        testZyfw.d=1;
//      testZyfw.c=2  //不能访问c
//        Zuoyongfanwei2 zuoyongfanwei2=new Zuoyongfanwei2(); //frendly类不可以被本包外类访问
      //  Zuoyongfanwei2.Tt // 无法被访问
    }
}
