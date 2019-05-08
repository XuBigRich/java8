package classDemo.xiushifu2;

//import classDemo.xiushifu.A;  属于friendly作用域的类 不可以被包外的 类导入与访问

import classDemo.xiushifu.Zuoyongfanwei;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestZyfw.java
 * @Description  说明 默认default 只能在 本包中访问 即使是子类也不可以访问
 *                      protected 可以在  子类中 访问
 * @createTime 2019年04月18日 18:04:00
 */
public class TestZyfw extends Zuoyongfanwei {  //这个地方无法继承Zuoyongfanwei2所以不写作用域 就无法被其他包继承
  public TestZyfw(){
  }
    public void aa(){
        super.c=1; //protected  在 其他包中 只能由 子类去访问
        super.d=2;  // public

    }
    public static void main(String[] args) {
        Zuoyongfanwei zuoyongfanwei=new Zuoyongfanwei();
        //zuoyongfanwei.c;// 事实证明 虽然 main属于 Zuoyongfanwei 其子类TestZyfw 方法
        // 但 依然 无法 被访问 只能通过super去访问
        // (TestZyfw虽然 继承Zuoyongfanwei 但也属于 不同包 无法直接访问)
        //对照参考xiushifu 下 TestMain 函数  其可以直接访问 c属性
        TestZyfw testZyfw=new TestZyfw();
        testZyfw.c=1;   //这个地方 可以通过 其 子类去访问  c   因为 TestZyfw继承自uoyongfanwei拥有  c属性
        //Zuoyongfanwei.Pronbl pronbl=new Zuoyongfanwei().new Pronbl();  //子类 无法初始化 父类中 的设权限（protected）内部类 能访问
    }
}
