package mianshiti.lianJDK;

class A {
    public String show(D obj){  
           return ("A and D");  
    }   
    public String show(A obj){
           return ("A and A");
    }
}
////B类继承A类
class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){  
           return ("B and A");  
    }   
}
//C类继承自B类
class C extends B{}
//D类继承自B类
class D extends B{}
public class MultiTest{
    public static void main(String[] args){
        //只保留向上转型的方法(且是子类的方法)
        A ab = new B();
        B b = new B();
        D  d= new D();
        //他会找到最佳的匹配类型
        System.out.println(ab.show(b));
        //他会找到最佳的匹配类型
        System.out.println(ab.show(d));
    }
}