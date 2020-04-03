package io.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * java.nio.channels.Channel接口：
 *
 * 　　|--FileChannel
 *
 * 　　|--SocketChannel
 *
 * 　　|--ServerSocketChannel
 *
 * 　　|--DatagramChannel
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("119.163.195.106", 9069));
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(buf);
        System.out.println(bytesRead);
    }
}
