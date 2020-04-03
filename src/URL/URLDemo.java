package URL;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 通过URL访问 百度，获取文件输入流
 * 然后把网站输出到d盘的demo/baidu.txt文件中
 */
public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url=new URL("http://www.baidu.com");
        InputStream in= url.openStream();
        OutputStream out=new FileOutputStream("D://demo/baidu.txt");
        byte [] bytes=new byte[1024];
        int len=-1;
        while((len=in.read(bytes))!=-1){
            out.write(bytes,0,bytes.length);
        }
    }
}
