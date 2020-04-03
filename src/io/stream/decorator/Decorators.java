package io.stream.decorator;

import java.io.*;

/**
 * 装饰类
 */
public class Decorators extends FilterInputStream {
    protected Decorators(InputStream in) {
        super(in);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("d:/a.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        Decorators decorators=new Decorators(fileInputStream);
    }
}
