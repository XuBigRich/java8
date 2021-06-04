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
        char[] chars1 = new String(bytes).toCharArray();
        System.out.println();
        String decodeString = new String(Base64Utils.decodeBase64(bytes));
        char[] chars2 = decodeString.toCharArray();
        System.out.println(chars2);
        return decodeString;
    }

    //base64 编码
    public static String encode(byte[] bytes) {
        String encodeString = new String(Base64Utils.encodeBase64(bytes));
        return encodeString;
    }
}


