package erjinzhiyunsuan.yiweiyunsuan;

/**
 * 移位运算
 * 因为 一个int数字在计算机中第31位 位 符号位0 代表正数 1代表负数
 * 所以存在有符号移位和无符号移位区别
 * @Author： hongzhi.xu
 * @Date: 2020/11/13 下午8:41
 * @Version 1.0
 */
public class Learn {
    /**
     * 展示有符号移位
     */
    public static void signed(){
        String i = Integer.toBinaryString(-4);
        //打印出来 int类型4 的二进制形式
        System.out.println("-4的二进制（补码）形式："+i);
        //小技巧 通常往左移1位 代表*2 往右 移1位代表/2
        String g = Integer.toBinaryString(-4<<1);
        String f = Integer.toBinaryString(-4>>1);
        System.out.println("-4的二进制（补码）形式左移一位："+g);
        System.out.println("-4的二进制（补码）形式右移一位："+f);


    }

    /**
     * 展示有符号正整数移位
     */
    public static void signedz(){
        String i = Integer.toBinaryString(4);
        //打印出来 int类型4 的二进制形式
        System.out.println("4的二进制（补码）形式："+i);
        //小技巧 通常往左移1位 代表*2 往右 移1位代表/2
        String g = Integer.toBinaryString(4<<1);
        String f = Integer.toBinaryString(4>>1);
        System.out.println("4的二进制（补码）形式左移一位："+g);
        System.out.println("4的二进制（补码）形式右移一位："+f);
    }

    /**
     * 无符号位移
     */
    public static void unSigned(){
        String i = Integer.toBinaryString(-4);
        //打印出来 int类型4 的二进制形式
        System.out.println("-4的二进制（补码）形式："+i);
        //-4进行无符号右移 一位
        String g = Integer.toBinaryString(-4>>>1);
        System.out.println("-4的二进制（补码）形式无符号右移一位："+g);
    }

    /**
     * 无符号正整数位移
     */
    public static void unSignedz(){
        String i = Integer.toBinaryString(4);
        //打印出来 int类型4 的二进制形式
        System.out.println("4的二进制（补码）形式："+i);
        //-4进行无符号右移 一位
        String g = Integer.toBinaryString(4>>>1);
        System.out.println("4的二进制（补码）形式无符号右移一位："+g);
    }
    /**
     * 探究计算机中 正负数在内存模型中的表达方式
     * 1为负数 0为正数
     * 还牵扯到反码与补码问题
     */
    public static  void buma(){
        //1的正数是1
        //1的负数是11111111111111111111111111111111
        String i=Integer.toBinaryString(-2);
        System.out.println(i);
    }
    public static void main(String[] args) {
        signed();
        unSigned();
        signedz();
        unSignedz();
        buma();
    }
}
