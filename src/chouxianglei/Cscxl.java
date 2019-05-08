package chouxianglei;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName cscxl.java
 * @Description TODO
 * @createTime 2019年04月11日 18:12:00
 */
public abstract class Cscxl {
    public abstract void say();
    public void say(String s){
        System.out.println(s+"我是抽象类中 有方法实现的 方法");
    }
    public void say(Integer s){
        System.out.println(s+"我是抽象类中 父类的 方法");
    }
    public void say(boolean s){
        System.out.println(s+"我是抽象类中 有方法实现的 方法");
    }
}
