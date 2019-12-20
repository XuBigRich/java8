package io.decorator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 介绍装饰器 BufferedWriter
 * @author Administrator
 *知识点：
 *	1.字节流转化为字符流
 *	2.装饰器的使用
 *	3.输出/输入流 为何使用flush
 *	4.flush与close的关系 与区别
 *   4题 解： flush之后 输出流依旧可以使用 ，如果是close 之后 流将不可以再使用 （因为被关闭了）
 */
public class BufferedWriterAndReaderDemo {
	public static void main(String[] args) throws IOException {
		//字节流byte
		InputStream inputStream=new FileInputStream("e:/非道.rar");
		// 使用InputStreamReader 将 字节流转化为字符流
		//为什么要将字节流转化为字符流 （为了国际化）char
		InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
		//使用装饰器 将 字符流 
		BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
		String 	sss=	bufferedReader.readLine();
		System.out.println(sss);
		
		//输出byte
		FileOutputStream out=new FileOutputStream("E://A.txt");
		OutputStreamWriter outputStreamWriter=new OutputStreamWriter(out);
		outputStreamWriter.write(sss);
		//此处的flush 的意义 是将 放入io流的数据写入到 文件中去 （不管是write还是reader 都是 对流的操作）
		//注意：如果 在写入后不进行flush，那么写入的字符串将会在 io流中 消失；（可以尝试注释掉flush 看看效果）
		outputStreamWriter.flush();
		// close 的意义在于  flush（从流中写入）+close（关闭）
		outputStreamWriter.close();
	}
}
