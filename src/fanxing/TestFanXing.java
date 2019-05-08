package fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2019年04月12日 07:21:00
 */
public class TestFanXing {
    public static void main(String[] args) {
        Student student=new Student();
        Teacher teacher=new Teacher();
        STTeacher stTeacher=new STTeacher();
        List<Person> list=new ArrayList<>();
        list.add(student);
        list.add(teacher);  // 子类可以放入 父类的泛型当中  但是 会向上 转换（不是强转）为 父类 类型
        list.add(stTeacher);         // 丢失自己特有的方法，// 不过自己的重写的方法 不会丢失
        list.get(0).say();
        list.get(1).say();
        list.get(2).say();
        Class lass=list.get(2).getClass();
        System.out.println(lass.getName());  //
        Teacher s=new STTeacher();
        System.out.println(s.getClass().getName());
        double a=2.0;
        Integer d=(int)a;
        System.out.println(d.getClass().getName());
    }
}
