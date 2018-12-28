package Class.fanshe.fangfafanshe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
* 在计算机科学中，内省是指计算机程序在运行时（Run time）检查对象（Object）类型的一种能力，通常也可以称作运行时类型检查。
*不应该将内省和反射混淆。相对于内省，反射更进一步，是指计算机程序在运行时（Run time）可以访问、检测和修改它本身状态或行为的一种能力。
* */

public class MethodDemo {
    public static Method meth() throws NoSuchMethodException {
        A a=new A();
       Class c= a.getClass();
        /*
         * getMethod获取c的public方法
         * getDeclaredMethod获取自己声明的方法
         * */
        //因为第二个参数 为可变参数 所以 也可以传数组 也可以传 两个参数；
//        Method n= c.getDeclaredMethod("print",int.class,int.class);  //获取方法名为printd的方法 参数为 in类型的方法
        Method n= c.getDeclaredMethod("print",new Class[]{int.class,int.class});
        System.out.println(n.getName());
        return n;

    }
    public  static Method meth1(){
        Class b= A.class;
        Method[] t= b.getDeclaredMethods();
        for (Method f:t){
            System.out.println( f.getName());
            System.out.println(f.getReturnType());
            System.out.println();
            Class[] m=f.getParameterTypes();
            for(Class n:m)
                System.out.println(n.getSimpleName());
            if (f.getName().equals("print1")){
                return f;
            }
        }
        return null;
    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    	/*
    	*常用的方法调用
    	* */
        A a=new A();
    	a.print(1,2);
    		/*
    		* 使用反射 的方法调用
    		* 和a.print调用方法相同
    		* */
        Method method=	MethodDemo.meth();
      Object o=  method.invoke(a,1,2);  //方法如果没有返回值 就返回Null 如果有返回值 就返回具体的返回值
        System.out.println(o);
        System.out.println("===========================================");
        Method method1=MethodDemo.meth1();
        String[] t=(String[])method1.invoke(a,"a","B");
        for (String s:t){
            System.out.println(s);
        }

    }
}
class A{
    public void print(int a,int b){
        System.out.print(a+b);
    }
    public String[] print1(String b,String c){
       b= b.toUpperCase();
       c= c.toLowerCase();
        String[] e={b,c};
        return e;
    }
}
