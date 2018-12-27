package MD5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class Md5 {
    String a="许鸿志"; //加密目标
    byte[] encrypt=null;
    byte[] md5byt=null;
    public String conversion() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String tomd5=null;
        encrypt=a.getBytes("utf-8");//将加密目标转为 byte格式
        System.out.println("加密前的字符："+new String(encrypt,"utf-8"));
        System.out.println("没加密："+Arrays.toString(encrypt));//将字符串再转回String类型
        MessageDigest md5=MessageDigest.getInstance("MD5"); //声明加密方式 为MD5
        md5byt=md5.digest(encrypt);//将byte 转为md5格式的byte
        System.out.println("加密了："+Arrays.toString(md5byt)); //将加密后的byte 以string类型输出
        System.out.println("加密后的字符："+new String(md5byt,"utf-8"));
        /*
        * 因为 乱码 和 byte不方便 储存 所以 将 其转换为Base64的格式 加以储存
        * */
             String  aa= Base64.getEncoder().encodeToString(md5byt);
        return aa;
    }
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Md5 md5=new Md5();
        String f=md5.conversion();
        System.out.println(f);
    	}
}
