package fanxing;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Teacher.java
 * @Description TODO
 * @createTime 2019年04月12日 07:19:00
 */
public class Teacher implements Person {
    @Override
    public void say() {
        System.out.println("我是老师");
    }
    public void gz(){
        System.out.println("我的任务是工作");
    }
}
