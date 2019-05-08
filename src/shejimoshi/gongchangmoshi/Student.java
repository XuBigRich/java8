package shejimoshi.gongchangmoshi;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2019年04月11日 20:29:00
 */
public class Student implements Person {

    @Override
    public void say(String name) {
        System.out.println("我"+name+"是学生！");
    }
}
