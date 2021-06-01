package RSA;

/**
 * base64的使用
 */
public class Base64Coded {
    public static void main(String[] args) {
        String string = "qianyang123";
        //编码
        String encode = encode(string.getBytes());
        System.out.println(string + "\t编码后的字符串为：" + encode);
        //解码
        String decode = decode(encode.getBytes());
        System.out.println(encode + "\t字符串解码后为：" + decode);
    }

    //base64 解码
    public static String decode(byte[] bytes) {
        return new String(Base64Utils.decodeBase64(bytes));
    }

    //base64 编码
    public static String encode(byte[] bytes) {
        return new String(Base64Utils.encodeBase64(bytes));
    }
}


