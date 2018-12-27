package Class.fanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
* 反射 与 泛型 作用
* */
public class MethodzuoyongDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList a=new ArrayList();
        ArrayList<String> b=new ArrayList<String>();
        a.add(1);
        //反射的操作都是编译之后的操作
        System.out.println(a.getClass()==b.getClass());
        /*
        * a==b结果返回ture  说明 泛型编译之后 是去泛型化的
        *java中 集合的泛型 是防止错误输入的 只在编译阶段有效
        * 绕过编译 就无效了
        * */

       Class s= Class.forName("java.util.ArrayList");
       Method d= s.getDeclaredMethod("add",Object.class);
       d.invoke(b,1000);
       System.out.println(b.size());  //能打印长度成功 说明 添加成功
        System.out.println(b.get(0)); //ClassCastException 类型转换异常 说明 在添加成功后 打印时 还需要经过泛型检查




    }

}
