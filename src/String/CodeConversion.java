package String;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 编码转换 （精读）
 * 在计算机中固定的 字符 有固定的 字节数组表示，和固定的unicode编码
 * Unicode 是唯一的字符描述表
 *
 * 我们可以理解为 unicode 与 字节数组 为一一对应关系
 *
 * utf-8  与 GBK 对unicode 进行了再编码
 *
 * 当一个GBK编码的 字符 使用UTF-8的方式取解码时，他们对unicode映射可能会出现问题，于是字节数组也可能出现问题
 * 所以造成了乱码问题
 *
 * @author 许鸿志
 * @since 2021/9/17
 */
public class CodeConversion {
    private static String aa;
    private static String bb;

    //将许鸿志 这三个中文 的编码 使用ISO_8859_1形式的编码打乱 （预备工作）
    public static void disorganize() {
        //因为本系统使用的编码是utf-8，所以许鸿志这三个字需要使用utf-8的形式 转为 字节
        //得到字节数组后,我们new 一个字符串对象，使用 ISO_8859_1的形式将字节进行编码
        aa = new String("许鸿志".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
    }

    //检测许鸿志 是否已经不可以在本编码环境下显示
    public static void detection() {
        System.out.println(aa);
    }

    // 将乱码的字符串重新编码
    public static String newCode(String s, Charset charset) {
        //将得到的乱码字符串，按照原来的编码格式通过getBytes 获取到他的字节数组
        byte[] bytes = s.getBytes(charset);
        //使用字符数组重新进行编码，默认 使用utf-8  也可使bb = new String(bytes， StandardCharsets.UTF_8);
        return bb = new String(bytes);
    }

    public static void main(String[] args) {

        disorganize();
        detection();
        //因为aa原来是使用ISO_8859_1进行编码 的所以 要获取aa的标准二进制，需要通过ISO_8859_1编码形式获取
        bb= newCode(aa, StandardCharsets.ISO_8859_1);
        System.out.println(bb);
        System.out.println(aa);
    }
}
