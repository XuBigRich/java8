package erjinzhiyunsuan.anweiyunsuan;

/**
 * 学习 与(&) 、 或(|)  、  非（～） 、异或（^）
 *
 * @Author： hongzhi.xu
 * @Date: 2020/11/7 4:07 下午
 * @Version 1.0
 */
public class Learn {


    /**
     * 演示与 &
     * 位与 就是都为1 为1 其他为 0
     */
    public static void and(){
        String i = Integer.toBinaryString(4);
        String g = Integer.toBinaryString(6);
        //打印出来 int类型4 的二进制形式
        System.out.println("4的二进制形式："+i);
        //打印出来 int类型6 的二进制形式
        System.out.println("6的二进制形式："+g);

        String a=Integer.toBinaryString(4&6);
        System.out.println("4与6的二进制形式："+a);
    }

    /**
     * 演示 或 ｜
     * 位或 就是 有1 为 1 ，无1 为0
     */
    public static void or(){
        String i = Integer.toBinaryString(4);
        String g = Integer.toBinaryString(6);
        //打印出来 int类型4 的二进制形式
        System.out.println("4的二进制形式："+i);
        //打印出来 int类型6 的二进制形式
        System.out.println("6的二进制形式："+g);

        String o=Integer.toBinaryString(4|6);
        System.out.println("4或6的二进制形式："+o);
    }


    /**
     * 演示非 ~
     * 位非 就是与原来的 二进制完全反着！！！
     */
    public static void wrong() {
         String i = Integer.toBinaryString(4);
         String g = Integer.toBinaryString(6);
        //打印出来 int类型4 的二进制形式
        System.out.println("4的二进制形式："+i);
        //打印出来 int类型6 的二进制形式
        System.out.println("6的二进制形式："+g);

        String f4=Integer.toBinaryString(~4);
        String f6=Integer.toBinaryString(~6);
        System.out.println("位非4的二进制形式："+f4);
        System.out.println("位非6的二进制形式："+f6);
    }

    /**
     * 演示异或
     *     1^1=0    1^0=1      0^1=1     0^0=0
     */
    public static void xor() {
        String i = Integer.toBinaryString(4);
        String g = Integer.toBinaryString(6);
        //打印出来 int类型4 的二进制形式
        System.out.println("4的二进制形式："+i);
        //打印出来 int类型6 的二进制形式
        System.out.println("6的二进制形式："+g);
        String yh = Integer.toBinaryString(4^6);
        System.out.println("4异或6："+yh);

    }

    public static void main(String[] args) {
        and();
        System.out.println("==============");
        or();
        System.out.println("==============");
        wrong();
        System.out.println("==============");
        xor();
    }
}
