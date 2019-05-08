package String;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Indexof.java
 * @Description TODO
 * @createTime 2019年05月07日 10:46:00
 */
public class Indexof {
   static String var="asdfgsh";

    public static void main(String[] args) {
        System.out.println(var.substring(0));
        System.out.println(var.substring(2));
        System.out.println(var.lastIndexOf("w"));  //最后一个 w 出现的位置  如果没有 就返回 -1
        System.out.println(var.lastIndexOf("s"));  //最后一个 s出现的位置
        System.out.println(var.indexOf('s'));       // 最开始 一个s 出现的 位置
    }
}
