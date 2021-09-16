package erjinzhiyunsuan.xiaojiqiao;

/**
 * 位运算 与移位小技巧
 * 位运算的操作优势  远远优于直接乘除
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
     * 取模操作 （注意取模和取余有一定区别）
     *
     *  a % (2^n)  = a & (2^n -1)
     */
    public static void remainder1(){
        Long t1=System.nanoTime();
        System.out.println(18%4);
        Long t2=System.nanoTime();
        System.out.println((t2-t1));
    }

    /**
     * 产生对比 充分展现 位操作在速度上展示的 优势
     */
    public static void remainder2(){
        System.out.println(18&(4-1));
        Long t2=System.nanoTime();
        Long t3=System.nanoTime();
        System.out.println((t3-t2));
    }



    public static void main(String[] args) {
        displacement();
        remainder1();
        remainder2();
    }
}
