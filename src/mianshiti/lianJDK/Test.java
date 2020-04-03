package mianshiti.lianJDK;

/**
 * java中 如果 存在子父类情况，那么java会找到最佳匹配类型
 */
public class Test {

    public static void sayHello(Object to){
        System.out.println(String.format("Welcome,%s",to));
    }
    public static void sayHello(String to){
        System.out.println(String.format("Hello,%s",to));
    }
    public static void main(String args[]){
        String s="tommy";
        Object o=s;
        sayHello(o);

        sayHello(s);
    }
}
