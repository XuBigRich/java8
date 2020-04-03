package io.stream.read;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDemo {
    /*
    * 读取指定文件内容  按照16进制输出到控制台
    * 并且每输出10个换行
    * */
    public static void  prinHex(String string) throws IOException {
       /* File file=new File(string);
        RandomAccessFile raf= new RandomAccessFile(file,"r");
        byte[] bytes= new byte[(int)raf.length()];
        raf.read(bytes);
        System.out.println(Arrays.toString(bytes));*/
       // 把文件 作为字节流 进行读操作
        FileInputStream in=new FileInputStream(string);
        int b;
        int i=1;
        /*
        * 将in中内容（内容以byte储存）读出
        * 返回每个字节的十进制形式
        * 当字节 为11111 int 为-1时  读取结束
        * */
        while ((b=in.read())!=-1){
            System.out.print("十进制:"+b+" ");
            System.out.print("十六进制:"+Integer.toHexString(b)+"; ");
            for(int c=0;c<4;c++) {
                byte x=(byte)(b>>>24);
                byte h=(byte)(b>>>16);
                byte z=(byte)(b>>>8);
                byte f=(byte)(b);
                byte [] m=new byte[4];
                System.out.println("数组为： ["+m[0]+" "+m[1]+" "+m[2]+" "+m[3]+"]");
                System.out.println("byte:" + (byte) b);
            }
            i++;
            if(i==10){
                i=0;
                System.out.println();
            }
        }
        in.close();
    }
    public static void printByByteArray(String filename) throws IOException{
        FileInputStream in =new FileInputStream(filename);
        byte[] bytes=new byte[20*1024];
        /*
        * 将in中读出来的东西放入bytes中
        * 从bytes的off位置开始
        * 最多存放len长度的数据 、
        * 返回 读到的字节的个数
         * */
        int v=0;
        int a=in.read(bytes,0,bytes.length);
        for(int i=0;i<a;i++){
            System.out.println(Integer.toHexString(bytes[i]));
            v++;
            if(v==10){
                v=0;
                System.out.println();
            }
        }


    }
    public static void main(String[] args) throws IOException {
        prinHex("D:\\demo\\wenjian.txt");
        printByByteArray("D:\\demo\\wenjian.txt");
    	}
}
