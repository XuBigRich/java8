package String;

import java.io.UnsupportedEncodingException;

public class ByteDemo {
    /*
    * String=====>byte
    * String 转换成byte需要 根据编码 转换
    * */
    String a="许鸿志";
    //默认转换
    public byte[] morenzhuanhuan(){
       // "默认转换的话 是根据java的默认编码进行转换 如 右小角utf-8 则默认转换格式为utf-8"
        byte[] bytes=a.getBytes();
        System.out.println("使用默认 转码 的byte:");
        for(Byte by : bytes){
            System.out.print(by+" ");
        }
        return bytes;

    }
    //使用utf-16be转换String类型
    public byte[] zhuanhuanutf16() {
        System.out.println("指定utf16 转码 的byte:");
        try {
            byte[]  bytes = a.getBytes("UTF-16BE");
            for(byte bytes1:bytes) {
                System.out.print(bytes1 + " ");
            }
            return bytes;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
            ByteDemo byte1=new ByteDemo();
    		byte1.morenzhuanhuan();
    		System.out.println();
    		byte1.zhuanhuanutf16();
            System.out.println();
    		//可以看出 相同一个字符串  因为 编码不同 转换后的byte（字节） 也会不同
            //同理 由byte（字节）转化为字符串 也必须 使用相同编码 要不然会乱码
           byte[] utf8= byte1.morenzhuanhuan();
             System.out.println();
           byte[] utf16= byte1.zhuanhuanutf16();
             System.out.println();
            System.out.println("指定utf16 转码:"+new String(utf8,"utf-16be"));
            System.out.println("指定utf16 转码:"+new String(utf16,"utf-16be"));
            //下面 通过使用指定（也是默认）编码utf8 转码将变正常
             System.out.println("使用指定（也是默认）编码utf8 转码:"+new String(utf8,"utf8"));
            // 不加参数 会使用系统默认编码 转码
            System.out.println("系统默认编码 转码:"+new String(utf8));
    	}

}
