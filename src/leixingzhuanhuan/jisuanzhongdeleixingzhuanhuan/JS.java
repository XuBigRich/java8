package leixingzhuanhuan.jisuanzhongdeleixingzhuanhuan;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JS.java
 * @Description 计算中时 基本类型的 自动转换
 * @createTime 2019年04月26日 13:54:00
 */
/*
* 1.若参与运算的数值类型 不同，则先转换成同一类型，然后运算
* 2.转换按照数据长度增加的方向进行 以保证 精度不降低 例如int与long 运算时先把int转换成long 再运算
* 3.所有浮点运算都是双精度进行的，即使仅包含float单精度的运算表达式 也要转换成double型
* 4.char型和short型参与运算时，必须先进行转换成int型
* 5.只要有浮点类型参与运算 一律 转成浮点类型  不管  谁的 长度 大小
* */
public class JS {
    static char a='c';  //2个字节
    static short b=1;   //2个字节
    static float c=2;   //4个字节
    static float c1=2;   //4个字节
    static double d=3;  //8个字节
    static int e=4;     //4个字节
    static int e1=4;     //4个字节
    static long f=5;    //8个字节
    static long f1=5;    //8个字节
    public static void main(String[] args) {
        //char aa=a*b;
        //short aa=a*b;
        int aa=a*b;  /*char在运算时 转换为int 因为int 占用4个字节 32位 short占用2个字节16位 所以 自动转换为int*/
        System.out.println(aa);
        float bb=a+c;  /*2个字节与4个字节 计算 需要以字节多的 为准 确保精度*/
        System.out.println(bb);
        long cc=e+f;    /*与上面同一道理*/
        System.out.println(cc);
        float dd=c+c1;
        System.out.println(dd);
        float ff=e+c;   /*浮点 与 整形 (字节大小一样的情况下)计算    需按照浮点为主 转换*/
        System.out.println(ff);
//        long gg=c+f;   /*浮点 与 整形 计算 必须用浮点 来接收*/
        float hh=c+f;
        System.out.println(hh);
        float aafsa=f1+f; /*不管时int long shor都可以用浮点接收*/
        System.out.println(aafsa);
        float ii=e+f;   /* 即使两个运算 字节大小不一致且都比float大 也可以*/
        System.out.println(ii);
        //float jj=c+d;
        double jj=c+d;
        System.out.println(jj);  /* 双精度浮点 与单精度浮点 运算  转换为双精度 浮点 */
    }
}
