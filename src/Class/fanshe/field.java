package Class.fanshe;

import Class.fanshe.gouzaohanshu.Person;

import java.lang.reflect.Field;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName field.java
 * @Description TODO
 * @createTime 2019年03月31日 13:25:00
 */
public class field {
    public static void main(String[] args) throws IllegalAccessException {
        Person person=new Person("AAA");

        Field[] fields=Person.class.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field.getName().equals("aaa"));
        }
        try {
            Field field=Person.class.getDeclaredField("aaa");
            field.setAccessible(true);  //对所有属性设置访问权限  当类中的成员变量为private时 必须设置此项
            System.out.println(field.get(person));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
