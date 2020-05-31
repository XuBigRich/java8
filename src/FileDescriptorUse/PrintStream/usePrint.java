package FileDescriptorUse.PrintStream;

/**
 * Hello world 是每个编程语言的学习最初打印到控制台的一段话
 * 但是 程序输出hello world 的过程到底做了什么呢。 今天我们就来深入的学习以下
 */
public class usePrint {

    public static void helloworld() {
        System.out.println("FileDescriptorUse.hello world!");
    }

    public static void main(String[] args) {
        //要想学习输出，我们先打印以下万物之源
        helloworld();
        //了解以下System这个类的out属性 进入源码 发现初始化状态下System的out  为null 而out属性的 类是PrintStream类型
//         若要学习请移步PrintStream

    }
}
