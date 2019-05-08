package Static;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName FlStatic.java
 * @Description TODO
 * @createTime 2019年04月19日 14:07:00
 */
public class FlStatic {
    public static int v=1;
    static int c;
    public static int aaa(){   //这个方法 主要是测试 是否 静态方法可以被重写
        c++;
        System.out.println(c);
        return  c;
    }
    public static int bbb(){  //这个 方法主要测试 如果子类调用 bbb 是否调用的 是 父类的bbb
        v++;
        System.out.println(v);
        return  v;
    }
    static{
        System.out.println("静态块");
    }
    FlStatic(){

    }
}
