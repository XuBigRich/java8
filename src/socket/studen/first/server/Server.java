package socket.studen.first.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static int port = 6666;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		String QUIT="quit";
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader consoler = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				String msg=null;
				//判断 因为种种原因 客户端已经断开 那么 就无需进入while循环了
				while((msg = consoler.readLine())!=null) {
					System.out.println("客户端[" + socket.getPort() + "]已连接");
					System.out.println("客户端[" + socket.getPort() + "]：" + msg);
					writer.write(msg + "\n");
					writer.flush();
					System.out.println("flush完成");
					//其实并没有起作用  在客户端关闭后   while循环 已经不成立了  循环就结束了
					if(QUIT.equals(msg)) {
						System.out.println("客户端["+socket.getPort()+"]已断开连接");
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(serverSocket!=null) {
				try {
					serverSocket.close();
					System.out.println("关闭serverSocket");
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
