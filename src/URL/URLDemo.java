package URL;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 关于创建URL实例对象一定要 前面携带协议 如http协议 file协议 等等！！！！！
 * 通过URL访问 百度，获取文件输入流
 * 然后把网站输出到d盘的demo/baidu.txt文件中
 */
public class URLDemo {
    public static void  accessHttp() throws IOException {
        URL url=new URL("http://www.baidu.com");
        InputStream in= url.openStream();
        OutputStream out=new FileOutputStream("/Users/xuhongzhi/temp/test/config.properties");
        byte [] bytes=new byte[1024];
        int len=-1;
        while((len=in.read(bytes))!=-1){
            out.write(bytes,0,bytes.length);
        }
    }
    public static void accessFile() throws IOException {
        URL url=new URL("file:/Users/xuhongzhi/temp/test/config.properties/");
        InputStream in= url.openStream();
        OutputStream out=new ObjectOutputStream(System.out);
        byte [] bytes=new byte[1024];
        int len=-1;
        while((len=in.read(bytes))!=-1){
            out.write(bytes,0,bytes.length);
        }
    }

    public static void main(String[] args) throws IOException {
        accessHttp();
        accessFile();
    }
}
