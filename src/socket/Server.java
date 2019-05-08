package socket;

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
                Socket client=serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
