package String;

/**
 * @author 许鸿志
 * @since 2021/9/16
 */
public class StringDemo {
    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        char f = 'a';
        String c = new String("a");
        System.out.println(b == a);
        System.out.println(b == c);
//        System.out.println( b==f);
    }
}
