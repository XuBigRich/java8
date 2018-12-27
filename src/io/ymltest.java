package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ymltest {
    public void aaa() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\aa\\application.yml");
        FileOutputStream outputStream = new FileOutputStream("D:\\aa\\aa.yml");
        byte[] bytes = new byte[10];
        while (fileInputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
    }
    public static void main(String[] args) throws IOException {
    		ymltest ymltest=new ymltest();
    		ymltest.aaa();
    	}

}
