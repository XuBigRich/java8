package mianshiti.ClassLoaderMianshi;

class HlloA{
    private static int i=1;
    public HlloA(){
        System.out.println("HelloA");
        System.out.println(i);
    }
    {
        System.out.println("I m A class");
    }
    static {
        System.out.println("static A class");
        System.out.println(i);
}
}
public class HelloB extends HlloA{
    public HelloB(){
        System.out.println("HelloB");
    }
    {
        System.out.println("I m B class");
    }
    static {
        System.out.println("static B class");
    }
    public static void main(String[] args) {
        new HelloB();
    }
}
