package Primitive;
/*
* java默认输出10进制数字：
*
* 例：如果输入的是8进制 或16进制 数字
* 输出时 会 先转变为10进制数字 在输出
* */
public class IntDemo {
    //0x7fffffff为16进制的2147483647 int的最大值
    //16进制数字以0x开头
    static int a=0x7fffffff;
    //8进制数字以0开头
    static int b=01234567;
   //十进制数字 除了第一位不可以为0 其他位 0-9可以瞎鸡儿乱写
    static int c=1234567;
    //byte 等于-1时
    static byte d=-1;

    static int e=0x7fffffff;// 二进制形式 ： ‭000111001000‬

    public static void main(String[] args) {
        //当他输出a时会自动转为 十进制 数字输出
      /*  System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        int e=d;
        System.out.println(e);*/
        /*
        * 输出
        * 2147483647
        * */

        //二进制 右移 2 位  返回一个十进制
        /*
        * c 二进制为 ‭000100101101011010000111‬
        * 右移动 2 位 变为 1001011010110100001
        *  再将1001011010110100001 变为 十进制 并 以十进制输出
        *  所以 输出 308641
        * */
        System.out.println(c>>>2);
      //==============================================
        /*
        * 下面是个错误示范
        * */
        /*byte j=(byte)e;*/
        System.out.println(e>>>28&0xFF);
        System.out.println(e>>>16&0xFF);
        System.out.println(e>>>8&0xFF);
        System.out.println(e&0xFF);

    	}
}
