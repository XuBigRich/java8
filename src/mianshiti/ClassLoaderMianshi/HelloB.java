package mianshiti.ClassLoaderMianshi;

/**
 * 探究完整的子父类加载顺序
 *父类静态属性-》父类静态代码块-》子类静态属性-》子类静态代码块-》父类属性-》父类代码块-》父类构造函数-》子类属性-》子类代码块-》子类构造函数
 */
class HlloA {
    private static int i = 1;
    private static File file=new File("父类静态");
    private File filei=new File("父类");
    private int b = 1;

    public HlloA() {
        System.out.println("父类构造函数中的  HelloA");
        System.out.println("父类构造函数中的i:"+i);
        System.out.println("父类构造函数中的b:"+b);
    }

    {
        System.out.println("父类代码块中的    I m A class");
        System.out.println("父类代码块中的b:"+b);
    }

    static {
        System.out.println("父类静态代码块中的     static A class");
        System.out.println("父类静态代码块中的i:"+i);
    }
}

public class HelloB extends HlloA {
    private static File file=new File("子类静态");
    private File filei=new File("子类");
    public HelloB() {
        System.out.println("子类构造函数中的 HelloB");
    }

    {
        System.out.println("子类代码块中的   I m B class");
    }

    static {
        System.out.println("子类静态代码块中的    static B class");
    }

    public static void main(String[] args) {
        new HelloB();
    }
}
