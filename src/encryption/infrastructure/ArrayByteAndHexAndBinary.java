package encryption.infrastructure;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 探索 byte数组（字符数组）  16进制  2进制关系
 *
 * @Author： hongzhi.xu
 * @Date: 2022/2/9 10:14 上午
 * @Version 1.0
 */
public class ArrayByteAndHexAndBinary {
    protected final byte[] decodingTable = new byte[128];
    //判断是否是换行 \n  回车 \r  \空格
    private static boolean ignore(char var0) {
        return var0 == '\n' || var0 == '\r' || var0 == '\t' || var0 == ' ';
    }


    public int decode(String var1, OutputStream var2) throws IOException {
        int var5 = 0;

        int var6;
        for (var6 = var1.length(); var6 > 0 && ignore(var1.charAt(var6 - 1)); --var6) {
        }

        for (int var7 = 0; var7 < var6; ++var5) {
            while (var7 < var6 && ignore(var1.charAt(var7))) {
                ++var7;
            }

            byte var3;
            for (var3 = this.decodingTable[var1.charAt(var7++)]; var7 < var6 && ignore(var1.charAt(var7)); ++var7) {
            }

            byte var4 = this.decodingTable[var1.charAt(var7++)];
            if ((var3 | var4) < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }

            var2.write(var3 << 4 | var4);
        }

        return var5;
    }

    /**
     * 传入必须是偶数
     *
     * @param sm4Key
     * @return
     */
    private static byte[] hexToBin(String sm4Key) throws IOException {
        ArrayByteAndHexAndBinary arrayByteAndHexAndBinary = new ArrayByteAndHexAndBinary();
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        arrayByteAndHexAndBinary.decode(sm4Key, var1);
        return var1.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        //将15转换为二进制字符串形式
        //二进制和字节的关系   1字节 =255
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toHexString(15));
        //将数字17转换为 16进制  ——> 11
        //然后将 16进制的 11数字 转为 一个 二进制数组，每两个十六进制字符串，代表一个byte[] 数组
        byte[] bytes = hexToBin(Integer.toHexString(17));
        for (byte b : bytes) {
            System.out.print(b);
        }
        System.out.println();
        //探索一下 65535 用  byte数组表示
        System.out.println(Integer.toHexString(65535));
        byte[] s = hexToBin(Integer.toHexString(65535));
        for (byte b : s) {
            System.out.print(b);
        }
    }
}
