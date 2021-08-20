package Class.fanshe.Class;

import Class.Spring.shili.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * 获取类中的 任何信息
 * 都需要先获得类的 类类型（重要 ）
 * */
public class ClassUtil {
    public static void pritClassMessage(Object obj) {
        Class s = obj.getClass();//获取 这个 对象的 类 类型 ；
        System.out.println(s.getName());//获取这个 对象类 类型 的 类型 名称
        /*
         * 获取方法信息
         * */
//        Method[] ms = s.getMethods();//获取这个对象的 所有 公共的 类方法（包含父类的）
        Method[] ms=s.getDeclaredMethods();//获取这个 对象所有 方法 （包含父类，不问 访问权限）
        for (Method a : ms) {
            System.out.println("方法全称：" + a);//方法 的 全称
            System.out.println("方法名：" + a.getName());//方法 的 名
            System.out.println("方法返回值类型的类：" + a.getReturnType());//方法 的 返回值 类型 的 类 类型
            System.out.println("方法返回值类型的名：" + a.getReturnType().getName());//方法 的 返回值 类型 的 名
            System.out.println("方法所在类的类类型名称：" + a.getDeclaringClass().getName());
            /*
             *获取方法参数信息
             * */
            Class[] paramType = a.getParameterTypes();//获取方法参数列表的类型的类类型:
            for (Class param : paramType) {
                System.out.println("方法参数类型的类类型:" + param.getName());
            }
        }
        /*
         * 获取成员变量信息
         * */
        //获取公共的成员变量的信息
//            Field[] fs=s.getFields();
        //获取自己 所有的 成员变量信息
        Field[] fs = s.getDeclaredFields();
        for (Field filed : fs) {
            //得到成员变量的类类型
            Class fileType = filed.getType();
            //得到成员变量 名称
            String Typename = fileType.getName();
            System.out.println("成员变量类类型：" + fileType + "     成员变量类型名称：" + Typename);
        }
        //获取当前类的父类

        /*
         * 获取构造函数信息
         * */
        //获取所有共有的构造方法
        //Constructor[] gzhs=s.getConstructors();
        //获取所有构造法那个发
        Constructor[] gzhs = s.getDeclaredConstructors();
        for (Constructor g : gzhs) {
            String ww = gzhs.getClass().getName();
            System.out.println("获取所有构造方法：" + ww);
            Class[] param = g.getParameterTypes();
            for (Class z : param)
                System.out.println("获取所有构造方法参数：" + z);
        }

    }

    public static void main(String[] args) {
        //仔细甄别这里的不同 （Student.class的类类型是 Class ,new Student() 的类类型是Class.Spring.shili.Student）
        pritClassMessage(new Student());
//        pritClassMessage(Student.class);
    }
}
