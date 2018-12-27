package io;

import java.io.File;
import java.nio.file.Files;

/*
* File类用于表示文件（目录）与
*File类只用于表示文件（目录）的信息（名称，大小）不能用于文件访问
* */
public class FilesDemo {
    File file=new File("d:\\aaa");
    File files=new File("d:\\bbb\\ccc");
    //判断目录是否存在
    public void pdcz(){
       boolean ex= file.exists();
        System.out.println("file目录是否存在:"+ex);
    }
    //判断如果不存在 就创建目录
    public void careat(){
        if(!file.exists()){
            file.mkdir();
        }
        System.out.println("file目录是否存在:"+file.exists());
    }
    //判断如果存在就给他删掉
    public void delete(){
        if(file.exists()){
            file.delete();
        }
        System.out.println("file目录是否存在:"+file.exists());
    }
    //当两层文件同时不存在时使用mkdir 建立会失败
    public void creates1(){
        if(!files.exists()){
            files.mkdir();
        }
        System.out.println("使用mkdir建立文件群："+files.exists());
    }
    //当两层文件同时不存在时使用mkdirs
    public void creates2(){
        if(!files.exists()){
            files.mkdirs();
        }
        System.out.println("使用mkdirs建立文件群："+files.exists());
    }
    //只删除最后路径指向文件
    public void delects1(){
        if(files.exists()){
            files.delete();
        }
        System.out.println("files目录是否存在:"+files.exists());
    }
    //列出filelist下所有文件列表 的名字
    public void list(File filelist) {
        String[] fil = filelist.list();
        for (String f : fil) {
            System.out.println(f);
        }
    }
    //列出filelist下 所有文件的 对象
        public void list1(File filelist){
            File[] file= filelist.listFiles();
            for(File f:file){
                System.out.println(f);
            }
         }
         // 列出filelist下面所有文件
         public void listall(File filelist){
            //先获得filelist下面子目录
             File[] file= filelist.listFiles();
             for(File f:file){
                 //判断如果是目录则 进行 如下操作
                 if(f.isDirectory()){
                     list1(filelist);
                     }
                 }
             }

        public static void main(String[] args) {
            FilesDemo files=new FilesDemo();
    		/*
    		//查看file是否存在
    		files.pdcz();
    		//创建file
            files.careat();
            //删除file
            files.delete();
            //使用creat创建 文件群 （并不能创建成功）  但如果父级目录存在可以创建成功 路径 的 目标文件
            files.creates1();
            //使用creats创建文件群 （成功）
            files.creates2();
             //只删除最后路径指向文件
            files.delects1();
            */

    		//================================================
            File filelist= new File("D:\\Workspacess");
            //列出filelist下所有文件名  他只是字符串形式无法对 内容进行操作
            //files.list();
            //列出filelist下所有文件名  他只是字符串形式无法对 内容进行操作
            files.list1(filelist);
            //列出所有目录
            files.listall(filelist);
    	}
}
