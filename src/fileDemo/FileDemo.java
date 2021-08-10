package fileDemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
        FileWriter fileWriter = new FileWriter(filename, true);
        System.out.println(filename.getName());
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write("sb.toString()");
        bw.close();
    }

    //获取文件信息
    public static void geExternalForm() throws IOException, URISyntaxException {
        URL url = new URL("file:/C:/Program%20Files/Java/jdk1.8.0_281/jre/lib/charsets.jar");
        URI uri=url.toURI();
        File file = new File(uri);
        String externalForm = file.getCanonicalFile().toURI().toURL().toExternalForm();
        System.out.println(externalForm);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        File filename = createFile();
        write(filename);
        geExternalForm();
    }
}
