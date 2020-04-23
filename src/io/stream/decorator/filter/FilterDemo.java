package io.stream.decorator.filter;

import com.sun.org.apache.xalan.internal.xsltc.dom.FilterIterator;

import java.io.*;

public class FilterDemo {
   public FilterInputStream filterIterator;

    public FilterDemo() throws FileNotFoundException {
        InputStream fileInputStream=new FileInputStream("D");
        DataInputStream dataInputStream=new DataInputStream(fileInputStream);
//        filterIterator = new FilterInputStream(fileInputStream);
    }
}
