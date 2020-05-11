package getPath;

import java.net.URISyntaxException;

/**
 * 获取资源文件目录的多种方式 具体什么区别目前还不知道
 */
public class getPath {
    public static void main(String[] args) throws URISyntaxException {
        String filePath = getPath.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        System.out.println(filePath);
        filePath = System.getProperty("user.dir");
        System.out.println(filePath);
        //getResource 如果是一个不存在的文件则会报错
        filePath = Thread.currentThread().getContextClassLoader().getResource("config.properties").getPath();
        System.out.println(filePath);
        //getResource 如果是一个不存在的文件则会报错
        filePath = getPath.class.getClassLoader().getResource("config.properties").getPath();
        System.out.println(filePath);
    }
}
