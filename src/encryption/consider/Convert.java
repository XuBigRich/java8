package encryption.consider;

import java.nio.charset.StandardCharsets;

/**
 * 如何将16进制转换为 字符串 字节数组
 * 如何将字符串 转换为 16进制  字节数组
 * 如何将 字节数组 转换为  字符串  16进制
 *
 * @Author： hongzhi.xu
 * @Date: 2022/2/9 2:58 下午
 * @Version 1.0
 */
public class Convert {
    /**
     * 16进制转字符串
     *
     * @param hex
     * @return
     */
    public String HexToString(String hex) {
        return new String(HexToBytes(hex));
    }

    /**
     * 16进制转字节数组
     *
     * @param hexStr
     * @return
     */
    public byte[] HexToBytes(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 字符串转16进制
     *
     * @param str
     * @return
     */
    public String StringToHex(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return BytesToHex(bytes);
    }

    /**
     * 字符串转字节数组
     *
     * @param hex
     * @return
     */
    public byte[] StringToBytes(String hex) {
        return hex.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 字节数组转字符串
     *
     * @param bytes
     * @return
     */
    public String BytesToString(byte[] bytes) {
        return new String(bytes);
    }

    /**
     * 字节数组转16进制
     *
     * @param bytes
     * @return
     */
    public static String BytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        //得到b（他是一个补码）
        for (byte b : bytes) {
            //byte 会以补码的形式存储255，也就是1111 1111 ，取反 1000 0000 +1  = 1000 0001 （为-1）
            //当输出时JVM会自动将byte类型转换为int类型，符号位与数值位不变，中间填充0
            //输出 为 -1
            //       1000 0000 0000 0000 0000 0000 0000 0001  =-1
            System.out.println(b);
            //       1000 0000 0000 0000 0000 0000 0000 0001 & 0000 0000 0000 0000 0000 0000  1111 1111 1111
            //        0000 0000 0000 0000 0000 0000  0000 1111 1111
            System.out.println(b & 0XFF);
            String hex = Integer.toHexString(b & 0XFF);
            if (hex.length() == 1) {
                sb.append("0");
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //原码255  0000 0000 0000 0000 0000 0000 1111 1111  计算机 存储形式
        int target = 255;
        //输出255
        System.out.println(target);
        //1111 1111  计算机存储形式，展示byte时，用原码展示 所以为-1  （因为符号位变成了1 ，所以补码就与原码不一样了）
        System.out.println((byte)target);
        //255以补码形式存储进byte[] 数组， 是-1
        BytesToHex(new byte[]{(byte) target});
    }
}
