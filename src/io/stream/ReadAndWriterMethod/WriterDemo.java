package io.stream.ReadAndWriterMethod;

import classDemo.waibulei.W;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * writer是i/o操作中非常重要的一个方法，其与read一样有三个重载方法
 * <p>
 * 1.write(int b)    一将指定的字节写入此文件输出流。
 * <p>
 * 2.write(byte[] b)   将 b.length字节从指定的字节数组写入此文件输出流。
 * <p>
 * 3.write(byte[] b, int off, int len)从位于偏移量 off的指定字节数组写入 len字节到该文件输出流。
 */
public class WriterDemo {
    /**
     * 一个一个读
     * 一个一个写
     */
    public void writer() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/xuhongzhi/code/java8/src/io/stream/ReadAndWriterMethod/ReadDemo.java");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/xuhongzhi/code/java8/src/io/stream/ReadAndWriterMethod/ReadDemo");
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
     * 写入指定的bytes数组
     */
    public void writerOneParameter() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/xuhongzhi/code/java8/src/io/stream/ReadAndWriterMethod/ReadDemo.java");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/xuhongzhi/code/java8/src/io/stream/ReadAndWriterMethod/ReadDemo");
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
     * 带有数据偏移量的数组写入
     */
    public void writerThreeParameter() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/xuhongzhi/code/java8/src/io/stream/ReadAndWriterMethod/ReadDemo.java");
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/xuhongzhi/code/java8/src/io/stream/ReadAndWriterMethod/ReadDemod");
            int i = 0;
            byte[] bytes = new byte[1024];
            while ((i = fileInputStream.read(bytes)) != -1) {
                System.out.println(i);
                //从bytes数组中0开头的位置到i的数组长度的数据 写入到输出流中
                fileOutputStream.write(bytes, 0, i - 10);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WriterDemo writerDemo = new WriterDemo();
        writerDemo.writer();
        writerDemo.writerThreeParameter();
    }
}
