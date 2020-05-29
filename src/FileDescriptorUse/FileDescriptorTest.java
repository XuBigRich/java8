package FileDescriptorUse;

import java.io.*;

/**
 * FileDescriptor是"文件描述符".
 *  FileInputStream、FileOutputStream、SocketInputStream、SocketOutputStream中都有一个FileDescriptor对象
 * FileDescriptor可以被用来表示开放的文件,开放的套接字（socket  多新鲜呀，socket中文名叫套接字 原始套接字，流式套接字，数据报套接字）等.
 *
 * 当FileDescriptor表示文件来说,当FIleDescriptor表示某文件时,
 * 我们可以通俗的将FIleDescriptor看成该文件.
 * 但是,我们不能直接通过FIleDescriptor对该文件进行操作;
 * 若需要通过FIleDescriptor对该文件进行操作,则需要创建FileDescriptor对应的FileOutputStream,再对文件进行操作.
 *
 * ===================================================================
 *
 * in,out,err的介绍
 *
 *      in:标准输入(键盘)的描述符
 *     out:标准输出(屏幕)的描述符
 *     err:标准错误输出(屏幕)的描述符
 *
 * 他们三个的原理和用法都类似,下面通过out来进行深入的研究
 * ===================================================================
 *
 * out的作用和原理
 *
 * out是标准输出(屏幕)的描述符,但是他有什么作用呢?
 *
 * 我们可以通俗理解,out 就代表了标准输出(屏幕).如我们要输出信息到屏幕,可以通过out来操作,但是,out 有没有提供输出信息到屏幕的接口,怎么办呢?
 *
 * 很简单,我们创建Out对应的"输出流对象",然后通过"输出流"的write()等接口就可以输出信息到屏幕上去了.
 */
public class FileDescriptorTest
{
    private static final String FileName = "/Users/xuhongzhi/code/java8/src/FileDescriptorUse/file.txt";
    private static final String OutText = "Hi FileDescriptor";

    public static void main(String[] args) throws IOException
    {
         testStandFD();
//         testWrite();
//        testRead();
    }

    /**
     * 该程序的效果 等价于 System.out.println(OutText);
     *
     * @Method_Name: testStandFD
     * @Description: * void
     * @date 2018年11月11日
     * @author zhangj
     * @throws IOException
     */
    public static void testStandFD() throws IOException
    {
        FileOutputStream out = new FileOutputStream(FileDescriptor.out);
        PrintStream print = new PrintStream(out);
        print.write(OutText.getBytes());
    }

    /**
     * FileDescriptor写入示例程序
     *
     * @Method_Name: testWrite
     * @Description: * void
     * @date 2018年11月11日
     * @author zhangj
     * @throws IOException
     */
    private static void testWrite() throws IOException
    {
        // 新建file对应FileOutPutStream对象
        FileOutputStream fout = new FileOutputStream(FileName);
        // 获得file对应的FileDescripto对象
        FileDescriptor fd = fout.getFD();
        // 根据FileDescriptor创建fileOutPutStream对象
        FileOutputStream out = new FileOutputStream(fd.out);
        fout.write("Hello".getBytes());
        out.write("World".getBytes());
        out.close();
        fout.close();
    }

    private static void testRead() throws IOException
    {
        // 新建文件“file.txt”对应的FileInputStream对象
        FileInputStream fis = new FileInputStream(FileName);
        // 获取文件“file.txt”对应的“文件描述符”
        FileDescriptor fd = fis.getFD();
        // 根据“文件描述符”创建“FileInputStream”对象
        FileInputStream fiss = new FileInputStream(fd);
        System.out.println("in1.read():" + (char) fis.read());
        System.out.println("in2.read():" + (char) fiss.read());
        fis.close();
        fiss.close();
    }
}