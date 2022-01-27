package RSA;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 自己编写优美版
 *
 * @author 许鸿志
 * @since 2021/6/1
 */
public class MyRSAUtils {
    //非对称密钥算法
    public static final String KEY_ALGORITHM = "RSA";

    //私钥解密
    public static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    //公钥解密
    public static byte[] decryptByPublicKey(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //将公钥构造为X509样式的结构
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        //密钥工厂选择RSA
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //使用密钥工厂对X509样式的公钥 原文进行构造 变成一个真正的公钥
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        //初始化一个密码 此类提供用于加密和解密的加密密码的功能
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        //表示密码用于解密
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        //对数据进行解密
        return cipher.doFinal(data);
    }

    //私钥加密
    public static byte[] encryptByPrivateKey(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    //公钥加密
    public static byte[] encryptByPublicKey(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        Long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIR16NyikJk2SNITRlqr2yAUWwdmakjRLauJ3MDUOYmmXHGGe9PjjTb/rZV12rF0weDmTMnsXE7Oy8BXjSHszJcCAwEAAQ==";
        byte[] bytes = Base64Utils.decodeBase64(publicKey);
        byte[] ciphertext = encryptByPublicKey(String.valueOf(1623221262041L).getBytes(StandardCharsets.UTF_8), bytes);
        String base = Base64Utils.encodeBase64String(ciphertext);
        System.out.println(base);
    }
}
