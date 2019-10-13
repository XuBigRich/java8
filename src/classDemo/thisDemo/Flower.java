package classDemo.thisDemo;

/**
 * this 表示当前对象 （这个类被new 出来的reference）
 */
public class Flower {
    int petalCount=0;
    String s=new String("null");
    Flower(int petals){
        petalCount=petals;
        System.out.println("Constructor w/ int arg only,petalCount="+petalCount);
    }
    Flower(String ss){
        System.out.println("Constructor w/ String arg only, s="+ss);
        s=ss;
    }
    Flower(String s,int petals){
        this(petals);
//        this(s); can't call two!
        this.s=s;
    }
}
