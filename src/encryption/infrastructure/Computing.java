package encryption.infrastructure;

/**
 * 计算 很重要 经典 经典 经典 ，耗时两天
 * 介绍了  byte 如何强转 int  他的 byte存储格式
 * byte 转int  根据8位中的 最高位（符号位），如果为 1 补 1， 为0补0
 * int 转 byte ，永远只取 int 中的低8位 ，符号位不变 ，数字位取反+1，若为正数  则直接取低8位， 若为负数，存储转换后的低8位。
 * @Author： hongzhi.xu
 * @Date: 2022/2/10 9:12 上午
 * @Version 1.0
 */
public class Computing {
    public static void main(String[] args) {
        //0000 0000 0000 0000 0000 0000 0001
        int i = 1;
        // 10001 -> 1111 -> 1111 1111 1111 1111 1111 1111 1111 1111
        byte g = -1;
        System.out.println(i + g);

        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(1));
        //0000 0000 0000 0000 0000 0001 0000 0000
        System.out.println((byte) 256);

        System.out.println("开始重头戏");

        //1000 0000 0000 0000 0000 0001 0000 0001
        System.out.println(-257);
        //1000 0000 0000 0000 0000 0001 0000 0001  （int 十进制 原码）
        //1111 1111 1111 1111 1111 1110 1111 1111  （int 十进制 补码）
        System.out.println(Integer.toBinaryString(-257));
        //1000 0000 0000 0000 0000 0001 0000 0001  （int 十进制 原码）
        //1111 1111 1111 1111 1111 1110 1111 1111  （int 十进制 补码）
        System.out.println(Integer.toBinaryString(257));
        //0000 0000 0000 0000 0000 0001 1000 0001 （在这个基础上取低8位 为-1）
        System.out.println((byte) -257);
        //1000 0000 0000 0000 0000 0001 0000 0001  （int 十进制 原码）
        //0000 0001 （byte原码）
        // 符号位不变 与数字位取反+1
        //1111 1111 （byte计算机存储补码）
        //1111 1111 1111 1111 1111 1111 1111 1111  （十进制 补码）
        System.out.println(Integer.toBinaryString((byte) -257));
        //0000 0001 （byte原码）
        //因为是正数 所以原码 补码 反码相同
        //0000 0001 （byte计算机存储补码）
        //0000 0000 0000 0000 0000 0000 0000 0001  （十进制 补码）
        System.out.println(Integer.toBinaryString((byte) 257));

        //1000 0000 0000 0000 0000 0000 1000 0001  （int 十进制 原码）
        //1000 0001 （byte原码）
        // 符号位不变 与数字位取反+1
        //0111 1111 （byte计算机存储补码）
        //转 int 判断 符号位 为0 所以补0
        //0000 0000 0000 0000 0000 0000 0111 1111  （十进制 补码）
        //所以输出 111 1111
        System.out.println(Integer.toBinaryString((byte) -129));

        //1000 0000 0000 0000 0000 1000 0000 0001  （int 十进制 原码）
        //0000 0001 （byte原码
        // 符号位 不变  数字位 取反+1）
        //1111 1111 （byte计算机存储补码）
        //转 int 判断 符号位 为1 所以补1
        //1111 1111 1111 1111 1111 1111 1111 1111  （十进制 补码）
        //所以输出 1111 1111 1111 1111 1111 1111 1111 1111
        System.out.println(Integer.toBinaryString((byte) -2049));

    }
}
