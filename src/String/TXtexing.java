package String;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName tx.java
 * @Description TODO
 * @createTime 2019年03月26日 10:41:00
 */
public class TXtexing {
    public static void main(String[] args) {
        String s1= "FileDescriptorUse/PrintStream";
        String s2="world";
        String s3="helloworld";
        System.out.println(s3==s1+s2); //false
        System.out.println(s3.equals(s1+s2));  //true
        System.out.println(s3== "FileDescriptorUse/PrintStream" +"world"); //true
        System.out.println(s3.equals("FileDescriptorUse/PrintStream" +"world")); //true
        String s0="aaa";
        s0="2";
        System.out.println(s0);
    }

    /*
    * 反编译
    * */

    /*
    * public static void main(String[] args) {
        String s1 = "FileDescriptorUse.hello";
        String s2 = "world";
        String s3 = "helloworld";
        System.out.println(s3 == s1 + s2);   //两个变量 的 内存地址 相加 与s3的内存地址 比较  得出 内存地址不同 （事实上 他们的拼接 是new一个 新的地址 将 s1与s2拼接在一起）
        System.out.println(s3.equals(s1 + s2));
        System.out.println(s3 == "helloworld");  //常量池 中 找到了 helloworld 然后 进行 比较  得出 内存地址相同
        System.out.println(s3.equals("helloworld"));
    }
    * */
}
