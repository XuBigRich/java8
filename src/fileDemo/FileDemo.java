package fileDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static File createFile() {
        File myFile = new File("C:" + File.separator + "tmp" + File.separator, "test.txt");
        String path = myFile.getPath();
        System.out.println(path);
        return myFile;
    }
    public static void write(File filename) throws IOException {
        //这样可以直接生成一个文件 并且写入数据
//        FileWriter fileWriter = new FileWriter(filename.getName(),true);
        //也可按照目录文件地址去写入数据  但不会建立目录只会建立文件
        FileWriter fileWriter = new FileWriter(filename,true);
        System.out.println(filename.getName());
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write("sb.toString()");
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        File filename = createFile();
        write(filename);
    }
}
