package Class.fanshe.gouzaohanshu;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/*
* 有参构造器实例
* */
public class ConstructorDemo {
    public static void shili(String string) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Class c=Class.forName(string);
        // 获取构造方法
        Constructor a=c.getConstructor(String.class,String.class,int.class);
        //通过构造方法获取对象
        Person person=(Person)a.newInstance("许鸿志","男",20);
        System.out.println(person);
    }
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    		shili("Class.fanshe.gouzaohanshu.Person");
    	}
}
