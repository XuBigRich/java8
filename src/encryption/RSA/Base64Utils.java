package encryption.RSA;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64工具类
 *
 * @author 许鸿志
 * @since 2021/6/1
 */
public class Base64Utils {
    public static byte[] decodeBase64(byte[] bytes) {
        return Base64.getDecoder().decode(bytes);
    }

    public static byte[] decodeBase64(String bytes) {
        return Base64.getDecoder().decode(bytes);
    }

    /**
     * @param bytes
     * @return
     */
    public static byte[] encodeBase64(byte[] bytes) {
        String res = Base64.getEncoder().encodeToString(bytes);
        return res.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * 二进制转化为字符串
     *
     * @param bytes
     * @return
     */
    public static String encodeBase64String(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

}
