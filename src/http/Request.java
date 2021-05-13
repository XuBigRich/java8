package http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Request {
    //    String uri = "https://api.ownthink.com";
    String uri = "http://localhost.:8080";

    /**
     * Get方法
     */
    public void test1(String spoken) {
        try {
            URL url = new URL(uri + "/bot?appid=xiaosi&spoken=" + URLEncoder.encode(spoken, "utf-8"));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Post方法发送form表单
     */
    public void test2() {
        try {
            URL url = new URL(uri + "/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("username=root&password=root");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test3() {
        try {
            URL url = new URL(uri + "/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=--------------------------930312399930196524008471");

            FileReader fileReader = new FileReader(new File("/Users/xuhongzhi/studen/java8/src/http/PostBody"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            BufferedWriter bw = new BufferedWriter(new PrintWriter(new BufferedOutputStream(connection.getOutputStream())));
            String line1 = null;
            while ((line1 = bufferedReader.readLine()) != null) {
                bw.write(line1 + "\r\n\r\n");
                bw.flush();
            }
            bw.close();
            bufferedReader.close();


//            FileReader fileReader = new FileReader(new File("/Users/xuhongzhi/studen/java8/src/http/PostBody"));
//            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
//            char[] bytes = new char[1024];
//            int i = 0;
//            while ((i = fileReader.read(bytes)) != -1) {
//                pw.write(bytes, 0, i);
//            }
//            pw.close();
//            fileReader.close();


           /* FileInputStream fileInputStream = new FileInputStream(new File("/Users/xuhongzhi/studen/java8/src/http/PostBody"));
            OutputStream outputStream = connection.getOutputStream();
            byte[] bytes = new byte[1024];
            int i = 0;
            while ((i = (fileInputStream.read(bytes))) != -1) {
                outputStream.write(bytes, 0, i);
            }
            fileInputStream.close();
            outputStream.close();*/


            if (connection.getResponseCode() != 200) {
                connection.disconnect();
                return;
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line);
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Post方法发送json数据
     */
    public void test4() {
        try {
            URL url = new URL(uri + "/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

//            ObjectMapper objectMapper = new ObjectMapper();
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("{\"username\":\"root\",\"password\":\"root\"}");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Request reques = new Request();
//    	reques.test1("下午好");
//        reques.test2();
        reques.test3();
//        reques.test4();
    }
}