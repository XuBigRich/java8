package socket.basics.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private ServerSocket serverSocket;
    public Server(int port){
        try {
            this.serverSocket=new ServerSocket(port);
            System.out.println("启动成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        new Thread(()->doStart()).start();  //new 出一个线程 保证
    }
    private void doStart(){
        while(true){
            try {
            	// 当有 客户端连接serverSocket成功后  accept会返回一个 Socket对象
                Socket client=serverSocket.accept();
                //将返回的Socket对象放入 建立的 ClientHandler类中 建一个多线程
                //去储存这个socket对象
                new ClientHandler(client).start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
