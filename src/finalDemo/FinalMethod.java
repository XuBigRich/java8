package finalDemo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FinalMethod.java
 * @Description TODO
 * @createTime 2019年04月19日 13:31:00
 */
public class FinalMethod {
    final int a=1;
    int b=1;
    public final void say(){
        System.out.println("say final方法");
    }
    public void say(String a){
        System.out.println(a);     //说明final方法 可以在本类中重载  关于重载 看 17 20 示例
    }
    public void move(String a){  //17 ，20 实例了 重载方法
        System.out.println("aaa");
    }
    public void move(int a){
        System.out.println("aaa");
    }
}
