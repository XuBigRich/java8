package encryption.signature;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 签名，确定数据来源 SHA用于防篡改（类似于md5）
 * 如：
 *  对称加密，他们使用的是同一个密钥进行加解密的，因此无法真实确定数据来源。
 *  所以当加密方，使用约定好的签名对加密数据进行 签名时，解谜方只需要使用 约定的签名进行解谜，就知道了 这条数据来源于谁。
 *  因为签名只有双方知道，而加密密钥是所有人都知道的。
 *
 *  用签名与data报文 做签名逻辑，然后请求端与相应端 做对比，如果相等 则得知 数据没有被修改，并且可以确定 报文发送方
 *
 *  因此 加密密钥只有一个，但是签名 有几个用户就有几个签名，
 * @Author： hongzhi.xu
 * @Date: 2022/1/26 10:25 下午
 * @Version 1.0
 */
public class MacSignature {

    public static String signature(String singStr,String key) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("utf-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] bytes = sha256_HMAC.doFinal(singStr.getBytes("utf-8"));
        return new String(bytes);
    }
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        System.out.println(signature("1","1"));
    }
}
