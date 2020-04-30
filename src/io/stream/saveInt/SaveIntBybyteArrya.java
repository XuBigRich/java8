package io.stream.saveInt;

/**
 * 使用byte数组保存Int类型
 */
public class SaveIntBybyteArrya {
    public static byte[] int2Bytes() {
        //众所周知一个Integer 32位
        int taget = 9999; //二进制 00000000 00000000 ‭00100111 00001111‬
        //一个byte8个位 所以需要4个byte数组去接收
        byte[] bytes = new byte[4];
        bytes[3] = (byte) (taget >> 24);   //00000000
        bytes[2] = (byte) (taget >> 16);   //00000000
        bytes[1] = (byte) (taget >> 8);    //00100111‬
        bytes[0] = (byte) taget;           //00001111
        for (byte b : bytes) {
            System.out.println(b);
        }
        return bytes;
    }

    public static int bytes2Int(byte[] bytes) {
        //如果不与0xff进行按位与操作，转换结果将出错，有兴趣的同学可以试一下。
        int int1 = bytes[0] & 0xff;          //00000000 00000000 00000000 00001111
        int int2 = (bytes[1] & 0xff) << 8;   //00000000 00000000 00100111‬ 00000000
        int int3 = (bytes[2] & 0xff) << 16;  //00000000 00000000 00000000 00000000
        int int4 = (bytes[3] & 0xff) << 24;  //00000000 00000000 00000000 00000000

        return int1 | int2 | int3 | int4;  // 00000000 00000000 ‭00100111 00001111‬
    }

    public static void main(String[] args) {
        byte[] bytes = int2Bytes();
        int a = bytes2Int(bytes);
        System.out.println(a);
        Long aLong=11111111111111111l;
        System.out.println(aLong);
    }
}
