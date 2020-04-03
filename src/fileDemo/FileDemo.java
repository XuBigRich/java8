package fileDemo;

import java.io.File;

public class FileDemo {

    public static void main(String[] args) {
        File myFile = new File("C:" + File.separator + "tmp" + File.separator, "test.txt");
        String path=myFile.getPath();
        System.out.println(path);
    }
}
