package classDemo.xiushifu;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test1.java
 * @Description TODO
 * @createTime 2019年04月02日 20:34:00
 */
//接口声明default属性 可以设置默认方法方法体 并且此方法还可以被重写
public class DefaultTest implements DefaultTestDemo{
    public static void main(String[] args) {
        DefaultTest test1=new DefaultTest();
        test1.say();
    }
}
