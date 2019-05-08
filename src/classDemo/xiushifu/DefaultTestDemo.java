package classDemo.xiushifu;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description default修饰符
 * @createTime 2019年04月02日 20:34:00
 */
public interface DefaultTestDemo {
    default void say(){
        System.out.println("default输出！");
    }
}
