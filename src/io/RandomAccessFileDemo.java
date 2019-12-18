package io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/*
* RandomAccessFile是Java提供的 文件访问类
* RandomAccessFile可以随机访问文件 （根据关键字 访问文件的任意位置）
*（1）Java文件模型：
*   Java文件模型是byte byte byte储存的；是数据的集合
* （2）打开文件：
*  有两种方式 rw 与r
*  RandomAccessFile randomAccessFile=new RandomAccessFile(File ,"rw/r (读写类型)");
*  （3）关于随机访问文件：
*   为了实现随机访问文件包含一个文件指针； 当打开文件时 指针默认在开头point=0  读写的时候 指针就会移动；
*   好处：如果下载一个很大的文件；可以把文件分成很多个小任务，分别下载
*   （4）写方法：
*       raf.write(这里填你要写的东西(一个字节)）----->每次 只能写一个字节（后8位）同时指针指向下一个位置，准备再次写入;
*   （5）读方法
*       raf.read------->读一个字节
*     （6） 文件读写结束后 一定要关闭；
* */
public class RandomAccessFileDemo {
    //创建文件夹
    File demo=new File("D:\\demo");
   public void create (){
       if(!demo.exists()){
           demo.mkdir();
       }
   }
   //创建文件
   public void createtxt(){
       //在demo文件下创建一个名为wenjian.txt的文件
       File txt=new File(demo,"wenjian.txt");
       if(!txt.exists()){
           try {
               txt.createNewFile();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
    public static void main(String[] args) throws IOException {
        RandomAccessFileDemo randomAccessFileDemo=new RandomAccessFileDemo();
        //创建文件夹
        randomAccessFileDemo.create();
        //创建文件
        randomAccessFileDemo.createtxt();
        //声明要对 哪个文件 进行什么操作
        File file=new File("D:\\demo\\wenjian.txt");
        RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
       long zplace= randomAccessFile.getFilePointer();
        System.out.println(zplace);
        int i=0x7fffffff;
        randomAccessFile.write(i>>>24);
        randomAccessFile.write(i>>>16);
        randomAccessFile.write(i>>>8);
        randomAccessFile.write(i);
        System.out.println(randomAccessFile.getFilePointer());
        //下面这个方法只是对上面方法的封装
        randomAccessFile.writeInt(i);
        System.out.println(randomAccessFile.getFilePointer());
        String s="许";
        byte[] bytes=s.getBytes("utf-8");
        randomAccessFile.write(bytes);
        System.out.println(randomAccessFile.getFilePointer());
        //======================================
        //读文件
        randomAccessFile.seek(0);
        //声明一个byte数组 大小为randomAccessFile的长度
        byte[] buf=new byte[(int)randomAccessFile.length()];
        System.out.println("开始读取buf");
        System.out.println(buf);
        //在没有读到缓冲区前他的 每个byt都没有值  （因为buf和文件还没有建立关系）
        for(byte byt:buf){
            System.out.print(byt+" ");
        }
        //读取randomAccessFile 并给每个buf赋值 （buf和文件建立关系）
        randomAccessFile.read(buf);
        System.out.println();
        //读到缓冲区后 buf有值了
        for(byte byt:buf){
            System.out.print(byt+" ");
        }
        System.out.println("结束读取buf");
        //类似于 上边的遍历
        System.out.println(Arrays.toString(buf));
        String s1=new String(buf,"utf-8");
        System.out.println(s1);
        randomAccessFile.close();
    	}

}
