package socket.basics.server;

import java.io.*;
import java.net.Socket;
//火狐
//新客户端接入
//GET / HTTP/1.1
//Host: 127.0.0.1:8080
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
//Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
//Accept-Encoding: gzip, deflate
//Connection: keep-alive
//Upgrade-Insecure-Requests: 1
//
//
//chrome
//新客户端接入
//GET / HTTP/1.1
//Host: 127.0.0.1:8080
//Connection: keep-alive
//Cache-Control: max-age=0
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//Accept-Encoding: gzip, deflate, br
//Accept-Language: zh-CN,zh;q=0.9
//
//postman
//新客户端接入
//GET / HTTP/1.1
//cache-control: no-cache
//Postman-Token: 33a17e8c-5303-4c28-84a9-d8338a26e86a
//User-Agent: PostmanRuntime/7.6.1
//Accept: */*
//Host: 127.0.0.1:8080
//accept-encoding: gzip, deflate
//Connection: keep-alive
public class ClientHandler  {
    public static final int MAX_DATA_LEN=1024;
    private Socket socket;
    public ClientHandler(Socket socket){
        this.socket=socket;
    }
    //该方法 会创建一个线程
    public void start(){
        System.out.println("新客户端接入");
            new Thread(()->doStart()).start();
    }
    private void doStart(){
        try {
            InputStream inputStream=socket.getInputStream();
            while(true){
                byte[] data=new byte[MAX_DATA_LEN];
                while((inputStream.read(data,0,data.length))!=-1){
                    String message=new String(data);
                    System.out.println(message);
                    socket.getOutputStream().write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
