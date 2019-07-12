package jicheng.chushihualiucheng;

public class Parent {
    private int t=1;
    private int a;
    public static int v=2;
    public Parent(){
        System.out.println("父类被初始化");
    }
    public Parent(int a){
        System.out.println(a+"含参父类被初始化");
    }
    {
        System.out.println("父类的初始化块"+"t:"+t+" v:"+v+" a:" + a);
    }
    static{
        System.out.println("父类的静态块"+" v:"+v);
    }
}
