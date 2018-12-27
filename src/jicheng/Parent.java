package jicheng;

public class Parent {
    private int a;
    public Parent(){
        System.out.println("父类被初始化");
    }
    public Parent(int a){
        System.out.println(a+"子类被初始化");
    }
}
