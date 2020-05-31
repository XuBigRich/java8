package socket.basics.client;

import java.io.IOException;
import java.net.Socket;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2019年03月31日 20:48:00
 */
public class Client {
    private static final String Host="127.0.0.1";
    private static final int PORT=8080;
    private static final int SLEEP_TIME=5000;
    public static void main(String[] args) throws IOException  {
    		final Socket  socket=new Socket(Host,PORT);
    		new Thread(()->{
                System.out.println("客户端启动成功");
                while (true){
                    try {
                        String message="FileDescriptorUse.hello world";
                        System.out.println("客户端发送数据"+message);
                        socket.getOutputStream().write(message.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sleep();
                }
            }).start();
    	}
    	private static void sleep(){
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
