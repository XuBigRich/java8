package io.stream.xuliehua.standard;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化
 * 
 *  异常: io.netty.handler.codec.DecoderException: java.io.InvalidClassException: failed to read class descriptor
 *  异常产生原因
 * 在整个推的项目中，消息是一个Message类，Message必须转换为字节传输，
 * 因此在Message类中实现了Serializable接口，
 * 在服务器中将Message编码传输到客户端中解码，就是这个环节发生了错误，
 * 这是因为服务端的Message类和客户端的Message类的包路径不一样，导致编码和解码不一致，自然会报异常！
 * 
 * 所以要注意：
 * 
 *   1. 序列化的类最好加上serialVersionUID，免java.io.InvalidClassException，
 *    	不同的JVM对serialVersionUID的计算方法可能不一样，就算类的定义和序列化后的对象是一致的，
 *    	也可能从JVM-A里序列化后的对象到达JVM-B后，JVM-B认为 Class Invalid
 *   2.	服务端和客户端编解码的类的路径要一致
 * 
 * 
 * @author hongzhi.xu
 * @version 创建时间：2019年11月14日 上午10:41:46
 */
public class Deserialization {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//foo.ser 是一个 被 我删除的 类 序列号文件 ,所以 当我反序列化的时候  程序会报类没有找到
//		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("foo.ser"));
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Girlfriend.ser"));
		Girl aa=(Girl)ois.readObject();
		
		System.out.println("Girl：height="+aa.getHeight());
		System.out.println("Girl：old="+aa.getOld());
		
	}
}
