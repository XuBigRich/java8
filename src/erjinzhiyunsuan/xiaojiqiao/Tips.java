package erjinzhiyunsuan.xiaojiqiao;

/**
 * 位运算 与移位小技巧
 * @Author： hongzhi.xu
 * @Date: 2020/11/16 下午10:39
 * @Version 1.0
 */
public class Tips {
    /**
     * 2*2
     */
    public static void  displacement(){
        System.out.println(2*2);
        System.out.println(2<<1);

    }

    /**
     * 取模操作
     *  a % (2^n)  = a & (2^n -1)
     */
    public static void remainder(){
        System.out.println(18%4);
        System.out.println(18&(4-1));
    }

    public static void main(String[] args) {
        displacement();
        remainder();
    }
}
