package JMX.use;

import java.lang.management.ManagementFactory;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * MBean之间的通信是必不可少的，Notification就起到了在MBean之间沟通桥梁的作用。JMX 的通知由四部分组成：
 * <p>
 * 1、Notification这个相当于一个信息包，封装了需要传递的信息
 * <p>
 * 2、Notification broadcaster这个相当于一个广播器，把消息广播出。
 * <p>
 * 3、Notification listener 这是一个监听器，用于监听广播出来的通知信息。
 * <p>
 * 4、Notification filiter 这个一个过滤器，过滤掉不需要的通知。这个一般很少使用。
 * <p>
 * 这里我们使用日常打招呼的场景：jack与我偶遇，jack说：hi；我礼貌的回答：hello，jack。
 * <p>
 * 这里我们先分别创建两个资源：
 *一个是yunge，一个是jack。我们执行jack的hi方法后，去看下控制台上的打印信息；
 */
public class HelloAgent {
    public static void main(String[] args) throws JMException, Exception {
        //通过ManagementFactory工厂类创建一个MBeanServer 对象
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        //给要管理的对象类娶一个名字
        ObjectName helloName = new ObjectName("yunge:name=Hello");
        //创建要管理的对象
        Hello hello = new Hello();
        //将Mbean对象注册到 管理器中
        server.registerMBean(hello, helloName);
        //同上 创建也给jack对象
        Jack jack = new Jack();
        //将jack对象 取一个名字托管到 管理器中
        server.registerMBean(jack, new ObjectName("jack:name=Jack"));
        //给这个对象添加监听器,监听器为实现了NotificationListener接口的 HelloListener实现类
        jack.addNotificationListener(new HelloListener(), null, hello);
        Thread.sleep(500000);
    }
}