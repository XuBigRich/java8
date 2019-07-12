package classDemo.chushihua;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Demo.java
 * @Description TODO
 * @createTime 2019年05月27日 11:25:00
 */
public class Demo {
    public Demo(boolean a,String[] v){
        System.out.println("两参执行");
    }
    public Demo(String v){
        this(true,new String[]{v});
        System.out.println("一参执行");
    }
}
