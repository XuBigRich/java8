package io.ReadAndWriters;

import java.io.*;

/**
 * Read的存在是为了 推广Unicode
 * 原始的 stream 仅支持8-bit bytr stream 而 无法处理16-bit Unicode字符
 */
public class ReadAndWritersDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("d:/a.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
    }
}
