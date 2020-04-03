package socket.studen.first.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws IOException {
		String QUIT="quit";
		String ip = "127.0.0.1";
		int port = 6666;
		Socket socket = null;
		BufferedWriter write=null;
		BufferedReader reader=null;
		try {
		socket = new Socket(ip, port);
		reader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		write = new BufferedWriter(
				new OutputStreamWriter(socket.getOutputStream()));
		
		BufferedReader consoleReader = new BufferedReader(
				new InputStreamReader(System.in));     //这个地方 会阻塞 （疑似多线程）
		while(true) {
			String consoleContent=consoleReader.readLine();   //这个地方会阻塞（等待控制台输入）
//			发送消息给服务器
			write.write(consoleContent+"\n");
			write.flush();
			//读取服务器返回消息
			String msg=reader.readLine();  //这个地方会阻塞
			System.out.println(msg);
			if(QUIT.equals(msg)) {
				break;
			}
		}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(write!=null) {
				try {
					write.close();
					System.out.println("关闭socket");
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
		
}
