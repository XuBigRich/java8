package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* FileintputSteam与 FileoutputSteam 继承自IntputSteam与OutputSteam
*
* 其具体实现了 文件上 读取数据
* */
public class FileInputorOutputSteam {
    public static String path="D:\\测试";
    public static void copyByBytes(String a,String b) throws IOException {
        FileInputStream in =new FileInputStream(a);
        FileOutputStream out=new FileOutputStream("D:\\demo\\"+b+".txt");
        //表示bytes最多只能存放5个字节
        byte[] bytes=new byte[5];
        int j;
        int c=0;
        //有一个可能性 就是等in.read循环完之后 再赋值给j 那么读完后 他一定等于-1将 不进入while
        /*
        * 将in中读出来的东西放入bytes中 从bytes的off位置开始
        * 最多存放len长度的数据 返回 读到的字节的个数
         * */
        //因为文件流占有7个 字节 所以一次循环 是 执行不完的（bytes最长只能存5个字节）。
        // 所以读取的时候 第一次读了5个 然后 读2个
        while((j=in.read(bytes,0,bytes.length))!=-1){
            c++;
            //将bytes 写入out（也就是写入"D:\\demo\\"+b+".txt"）
            out.write(bytes);
            for(byte b1:bytes){
                System.out.print(b1+" ");
            }
            System.out.println();
            System.out.print("第 "+c+" 执行&&&&&");
            System.out.println("本次读取读到了 "+j+" 个字节");
        }
    }
    public static void copy(File file,File ofile) throws IOException {
        if(!ofile.exists()){
            ofile.createNewFile();
        }
        FileInputStream in=new FileInputStream(file);
        FileOutputStream out=new FileOutputStream(ofile);
        byte[] bytes=new byte[10];
        in.read(bytes,0,bytes.length);
        out.write(bytes);
    }
    /*
    * 下面是个错误示范 in.read()不可以直接写
    * */
    public static void copybyread(File file,File ofile) throws IOException {
        if(!ofile.exists()){
            ofile.createNewFile();
        }
        FileInputStream in=new FileInputStream(file);
        FileOutputStream out=new FileOutputStream(ofile);
        while(in.read()!=-1){
            int b=in.read();
            byte x=(byte)(b>>>24);
            byte h=(byte)(b>>>16);
            byte z=(byte)(b>>>8);
            byte f=(byte)(b);
            byte [] m={x,h,z,f};
            out.write(m);
            System.out.println("数组为： ["+m[0]+" "+m[1]+" "+m[2]+" "+m[3]+"]");
        }
    }
    public static void main(String[] args) throws IOException {
        copyByBytes("D:\\demo\\wenjian.txt","啦啦啦");

        File a=new File("D:\\\\demo\\wenjian.txt");
        File b=new File("D:\\测试\\a.txt");
        copy(a,b);

//        copybyread(a,b);// 错误示范运行 方法
   	}
}
