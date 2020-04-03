package io.stream.erjinzhi;

import sun.misc.BASE64Encoder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBytes {
    public static void main(String[] args) throws IOException {
        File file=new File("D:/数据库.png");
        byte[] bytes=new byte[(int)file.length()];
        long len = file.length();
        BufferedInputStream inputStream=new BufferedInputStream( new FileInputStream(file));
        int r = inputStream.read(bytes);
        if (r != len)
            throw new IOException("读取文件不正确");
        inputStream.close();
        BASE64Encoder encoder = new BASE64Encoder();
        String str=encoder.encode(bytes);
        System.out.println(str);
    }
}
