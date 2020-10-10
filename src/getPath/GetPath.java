package getPath;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 获取类所在项目路径，与访问项目下某资源
 * 获取资源文件目录的多种方式 具体什么区别目前还不知道
 */
public class GetPath {

    /**
     * 获取访问项目下根目录下的某个资源getResource("xxxx") 参数里面有值
     * 获取该资源所在的路径,打包前和打包后获取到的信息是不一样的
     * 打包前 是资源的绝对路径 例如: /Users/xuhongzhi/temp/test/config.properties
     * 打包后是定位到jar包的绝对路径加！资源路径 例如 ：file:/Users/xuhongzhi/temp/test/path.jar!/config.properties
     */
    public static void getResource() {
        String filePath;
        //获取当前线程上下文加载器所属项目的根目录下的config.properties文件， 如果是一个不存在的文件则会报错，存在就返回正常路径
//        filePath = Thread.currentThread().getContextClassLoader().getResource("config.properties").getPath();
//        System.out.println(filePath);
        //访问项目中的config.properties文件资源  如果是一个不存在的文件则会报错，存在就返回正常路径
//        filePath = GetPath.class.getClassLoader().getResource("config.properties").getPath();
    }

    /**
     * 获取访问项目下根目录绝对路径getResource("") 参数里面无值
     */
    public static void getResourcePath() {
        String path = GetPath.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
    }

    /**
     * 获取某个类所在的路径,打包前和打包后获取到的信息是不一样的
     * 打包后是定位到jar包的位置
     */
    public static void getClassPath() throws URISyntaxException {
        String filePath = GetPath.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        System.out.println(filePath);
    }

    /**
     * 获取系统配置重的项目路径
     */
    public static void getSysResource() {
        String filePath = System.getProperty("user.dir");
        System.out.println(filePath);
    }

    /**
     * 尝试通过文件流访问jar包里面的文件，失败了！
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void getJarResourceStream() throws IOException, URISyntaxException {
//        String path = "/Users/xuhongzhi/temp/test/target/path.jar!config.properties";
        String path = "file:/Users/xuhongzhi/temp/test/target/path.jar!/config.properties";
        FileInputStream fileInputStream = new FileInputStream(path);
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/xuhongzhi/temp/test/target/new");
        byte[] bytes = new byte[1024];
        while (fileInputStream.read(bytes) != -1) {
            fileOutputStream.write(bytes);
        }
    }

    public static void getJarResourceStream2() throws IOException {
//        String path = "/Users/xuhongzhi/temp/test/target/path.jar!config.properties";
        String path = "file:/Users/xuhongzhi/temp/test/target/path.jar!/config.properties";
        URL url = new URL(path);
        InputStream inputStream = url.openStream();
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/xuhongzhi/temp/test/target/new");
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            fileOutputStream.write(bytes);
        }

    }

    /**
     * *****高端操作*******
     * 尝试实例jar包中的某一个类，这个类会引用jar包外的某一个类方法。
     *
     * 准备材料：
     * 1.制作一个jar包 此jar包引用一个不属于本jar包的（在有道笔记有相应的包文件 可自行下载）
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void instantiation() throws MalformedURLException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String urlString = "file:/Users/xuhongzhi/temp/cn/piao888/out/tom.jar";
        URL url = new URL(urlString);
        URL[] urls = {url};
        ClassLoader classLoader = new URLClassLoader(urls);
        Class service = classLoader.loadClass("top.piao888.Tom");
        Method[] methods = service.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            //因为是main方法 是静态方法所以不需要传入实例就可以直接运行，但是需要添加参数，
            method.invoke(null,(Object)new String[]{"123", "456"});
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        getResource();
//        getResourcePath();
//        getClassPath();
//        getSysResource();
//        getJarResourceStream();
//        getJarResourceStream2();
        instantiation();
    }
}
