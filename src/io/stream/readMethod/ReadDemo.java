package io.stream.readMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * read方法是i/0操作中非常重要的一个方法 其有三个重载方法
 * 1.read()    一次读取一个字节的
 * <p>
 * 2.read(byte[] b)   从该输入流读取最多b.length字节的数据到字节数组。 此方法在没有数据的情况下会阻塞。
 * <p>
 * 3.read(byte[] b, int off, int len) 从该输入流读取最多len字节的数据为字节数组。
 * 如果len不为零，且不存在数据，那么该方法将阻塞，直到有数据传入; 否则，不会读取字节，并返回0 。
 */
public class ReadDemo {
    /**
     * 无参的read调用
     * 每次读取一个字节 while循环很多次
     */
    public void read() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/xuhongzhi/code/java8/src/io/stream/readMethod/ReadDemo.java");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/xuhongzhi/code/java8/src/io/stream/readMethod/ReadDemo");
            int i = 0;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println(i);
                fileOutputStream.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一个参数的read调用
     * 以byte数组的长度为读取单位 设单位为a
     * 从文件上读取a个长度的字节放入到预先声明的字节数组
     */
    public void readOneParameter() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/xuhongzhi/code/java8/src/io/stream/readMethod/ReadDemo.java");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/xuhongzhi/code/java8/src/io/stream/readMethod/ReadDemo");
            int i = 0;
            byte[] bytes = new byte[1024];
            while ((i = fileInputStream.read(bytes)) != -1) {
                System.out.println(i);
                fileOutputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 三个参数的read调用
     * 第三个参数：以第三个参数的大小为读取单位 设第三个参数为7
     * 第一个参数：从文件上读取7个长度的字节放入到第一个参数
     * 第二个参数：设第二个参数为5，那么就是从第一个参数的，第5位往后放
     */
    public void readThreeParameter() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/xuhongzhi/code/java8/src/io/stream/readMethod/ReadDemo.java");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/xuhongzhi/code/java8/src/io/stream/readMethod/ReadDemo");
            int i = 0;
            byte[] bytes = new byte[1024];
            while ((i = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
                System.out.println(i);
                fileOutputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadDemo readDemo=new ReadDemo();
        readDemo.readThreeParameter();
    }
}
