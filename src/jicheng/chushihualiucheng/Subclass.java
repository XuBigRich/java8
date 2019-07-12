package jicheng.chushihualiucheng;
/*
* JVM在装载类时）先装载类的静态成员，
* 再执行静态初始化块（同样，当一个类有继承自某类时，则会先装载该父类，
* 那么，父类的装载或执行顺序，也都如句子所述）。
*
*（在创建类的实例时）先执行实例初始化块，再执行构造器；
* 但对于一棵继承树中，会先调用父类的构造方法，那么其执行顺序也如句子所述。
*
*
* */
public class Subclass extends Parent {
    public int a=1;
    public static int v=2;
    public Subclass(){
        System.out.println("子类被初始化");
    }
    public Subclass(int a){
        System.out.println("子类含参构造器被初始化"+a);
    }
    {
        System.out.println("子类的初始化块"+"a"+a+"v:"+v);
    }
    static{
        System.out.println("子类的静态块"+"v:"+v);
    }

    public static void main(String[] args) {
//        Subclass a=new Subclass();
        Subclass b=new Subclass(1);
        Parent v=b;
        System.out.println(((Subclass) v).a);
    	}
}
