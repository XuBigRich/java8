package encryption.utils;

/**
 * 在加密过程中时常有将二进制转化为十六进制字符串的操作
 * 因为十六进制字符串好记，数字看起来不好记
 * 如：
 *  FF  一个字节 ，由两个字符描述   （重点 ，这里有特殊情况）
 *  0F 1F  描述了两个字节 , 而用数字表示则是，15 255
 *  很显然 ，16进制字符更简单明了
 *
 * @Author： hongzhi.xu
 * @Date: 2022/1/27 9:29 上午
 * @Version 1.0
 */
public class bitToString {
    public static void main(String[] args) {
        //因为byte 在Java中代表有符号 范围是 -127 - 128
        System.out.println("byte255在Java中的表现形式是-1，因为有符号:   "+(byte) 255);
        //与0xFF 做&运算 可以去掉符号位
        System.out.println((byte) 255 & 0XFF);
        //将数字转换为 16进制字符串
        String stmp = Integer.toHexString((byte) 255 & 0XFF);
        System.out.println(stmp);

        //特殊情况，当16进制的字符是个单字符时，我们就需要给他补足0了
        String tsqk = Integer.toHexString((byte) 13 & 0XFF);
        System.out.println("单字符描述一个字节，需要补足0:      "+"0"+tsqk);
    }
}
