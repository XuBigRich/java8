package FileDescriptorUse.PrintStream;

/**
 *
 */
public class LearSystemAndPrintStream {
    public static void main(String[] args) {
        //进入system out属性 得知out属性属于PrintStream类。继续看源码介绍进入PrintStream类学习文档。
        //其实在这之前还有一个问题就是PrintStream是如何被初始化的
        //这时候我们进入System类 ，根据介绍 PrintStream的初始化在initializeSystemClass()方法中 于是 进入System 查看这个方法具体实现
        System.out.println("FileDescriptorUse.hello world！");
        //根据介绍发现 不止out这个 变量在initializeSystemClass()方法中 被初始化  in out err都在这里 被初始化
//        public final static InputStream in = null;
//        public final static PrintStream out = null;
//        public final static PrintStream err = null;
        //根据源码阅读了解到PrintStream 这个类是System初始化各种，标准输入、输出、错误输出属性时
        // 生成初始化调用setin0 setout0 seterr0这种native方法的参数  具体介绍 看 《System类initializeSystemClass()方法讲解》 这篇文档
        /**
         *      private static native void setIn0(InputStream in);
         *     private static native void setOut0(PrintStream out);
         *     private static native void setErr0(PrintStream err);
         */
        //而生成PrintStream 的构造方法 我们是可以指定将 输出的文字 放入哪个文件当中
    }
}
