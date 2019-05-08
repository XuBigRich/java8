package shejimoshi.gongchangmoshi;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Teacher.java
 * @Description TODO
 * @createTime 2019年04月11日 20:28:00
 */
public class Teacher implements Person {
    @Override
    public void say(String name) {
        System.out.println("我"+name+"是老师！");
    }
}
