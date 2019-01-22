package jicheng.chushihualiucheng;

public class Subclass extends Parent {
    public Subclass(){
        System.out.println("子类被初始化");
    }
    public Subclass(int a){
        System.out.println("子类含参构造器被初始化"+a);
    }

    public static void main(String[] args) {
//        Subclass a=new Subclass();
        Subclass b=new Subclass(1);
    	}
}
