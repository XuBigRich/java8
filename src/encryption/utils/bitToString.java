package encryption.utils;

/**
 * 在加密过程中时常有将二进制转化为十六进制字符串的操作
 * 因为十六进制字符串好记，数字看起来不好记
 * 如：
 * FF  一个字节 ，由两个字符描述   （重点 ，这里有特殊情况）
 * 0F 1F  描述了两个字节 , 而用数字表示则是，15 255
 * 很显然 ，16进制字符更简单明了
 * <p>
 * 还有一个原因 就是
 * url请求时，参数中的+在服务器接收时为空格，导致AES加密报出javax.crypto.IllegalBlockSizeException: Input length must be multiple of 16 when decrypting with padded cipher
 * 为了避免 base64产出+号，我们索性 直接用16进制的形式 代替base64
 *
 * @Author： hongzhi.xu
 * @Date: 2022/1/27 9:29 上午
 * @Version 1.0
 */
public class bitToString {
    public static void main(String[] args) {
        //Java中的二进制都是采用补码形式存储
        // 在System.out.println调用时，JVM会自动将byte类型转换为int类型，此时进行的是有符号左移操作，前24位全部为1，后8为位1000 0000。
        //先看一下下面数字在jvm中 补码的存储形式的二进制形式
        System.out.println(Integer.toBinaryString(127));
        //为何-128 为 11111111111111111111111110000000，在输出byte时，只取低8位正好为 -128
        System.out.println(Integer.toBinaryString(-128));
        System.out.println(Integer.toBinaryString(-127));
        System.out.println(Integer.toBinaryString(255));
        //因为byte 在Java中代表有符号 范围是 -127 - 128 255以补码形式进行存储，得到源码续 取反+1 所以为-1
        //255的二进制为11111111 ，Java 默认他为补码，输出时展示源码，取反+1 ，所以为-1
        //输入补码  展示源码
        System.out.println("byte255在Java中的表现形式是-1，因为有符号:   " + (byte) 255);
        //与0xFF 做&运算 可以去掉符号位  实际上 255 在jvm中以补码
        System.out.println(Integer.toBinaryString(0Xff));
        //为什么是255
        //255&0xff的目的是为了 保持二进制补码的一致性。 --重点
        //但是因为 符号位的变化，所以 ，byte 与int 所展示的数据不同了 255是 十进制的255 二进制的-1
        System.out.println((byte) 255 & 0XFF);
        //因为 与0xFF 做了 &运算  转int 后 32位 最高位 变为了0，所以 变为 正数255
        System.out.println(Integer.toBinaryString((byte) 255 & 0XFF));
        //将int类型 255 数字转换为 16进制字符串
        String stmp = Integer.toHexString((byte) 255 & 0XFF);
        System.out.println(stmp);

        //特殊情况，当16进制的字符是个单字符时，我们就需要给他补足0了
        String tsqk = Integer.toHexString((byte) 13 & 0XFF);
        System.out.println("单字符描述一个字节，需要补足0:      " + "0" + tsqk);
    }
}
