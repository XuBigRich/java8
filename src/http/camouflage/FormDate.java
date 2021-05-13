package http.camouflage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author： hongzhi.xu
 * @Date: 2021/1/19 上午11:26
 * @Version 1.0
 */
public class FormDate {
    public static void test() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/xuhongzhi/studen/java8/src/http/camouflage/HttpPost");
            Socket socket = new Socket("127.0.0.1", 8080);
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((i = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, i);
            }
            fileInputStream.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
