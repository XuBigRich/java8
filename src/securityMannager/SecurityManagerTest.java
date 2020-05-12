package securityMannager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * https://blog.csdn.net/hjh200507609/article/details/50330773
 * https://www.cnblogs.com/itplay/p/10732329.html
 * <p>
 * 分下面几种情况运行程序：
 * 1.假如不添加启动参数直接运行，则相当于没有启动安全管理器，SecurityManager打印出来为null，
 * 且能正确读取protect.txt文件跟file.encoding属性。
 * 2. 添加启动参数-Djava.security.manager-Djava.security.policy=c:/protect.policy，
 * 俩参数分别代表启动默认安全管理器和指明策略配置文件路径。
 * 此时SecurityManager打印出来为不为null，但由于此时protect.policy里面并没有做任何授权，
 * 所以在读取文件的时就抛出AccessControlExcepti on异常。
 *
 * 使用启动参数的方式建立安全管理器 需要 在java -jar 后面添加 这个参数  idea的话 需要在 启动方法的Program arguments填入下面代码
 * -Djava.security.manager-Djava.security.policy=D:\studen\Java8\resources\java.policy
 * 也可以使用默认的安全管理器，直接new new SecurityManager() 就可以  其使用默认的
 */
public class SecurityManagerTest {

    public static void main(String[] args) throws FileNotFoundException {
        // 默认的安全管理器
//        System.setSecurityManager(new SecurityManager());
        System.out.println("SecurityManager: " + System.getSecurityManager());

        FileInputStream fis = new FileInputStream("D:\\studen\\Java8\\resources\\application.yml");

        System.out.println(System.getProperty("file.encoding"));

    }

}