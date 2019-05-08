package jicheng.aboutProperty;

public class Exetend {
    public static void main(String[] args) {
        new SuperClass();
        new SubClass();
    	}
}
class SuperClass{
    int a=5;
    public SuperClass(){
        test();       //当初始化子类时，默认先调用父类无参构造方法，若父类构造函数中的方法被子类重写，那么调用的是子类的方法；之所以输出0是因为当父类初始化时候 子类的 变量还没有初始化 所以 赋值没有起作用 输出为0
    }
    public void test(){
        System.out.println(a);
    }
}
class SubClass extends SuperClass{
    int a=6;
    public SubClass(){
        test();
        super.test();// 手动执行父类test方法 若要调用 父类方法  需要使用super关键字

    }
    public void test(){
        System.out.println(a);
    }
    public void test1(){
        System.out.println("被父类调用的子类方法");
    }
}
