package jar.getPath;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 获取类所在项目路径，与访问项目下某资源
 * 获取资源文件目录的多种方式
 * 存在很明显的打包前与打包后差异
 */
public class GetPath {



    /**
     * 获取访问项目下根目录绝对路径getResource("") 参数里面无值
     * 打包前是项目运行的根目录/Users/xuhongzhi/studen/java8/out/production/java8/（也类似于jar包位置，因为java8是编译之后的文件路径）
     * 打包后运行报错
     */
    public static void getResourcePath() {
        String path = GetPath.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
    }

    /**
     * 获取访问项目下根目录下的某个资源getResource("xxxx") 参数里面有值
     * 获取该资源所在的路径,打包前和打包后获取到的信息是不一样的
     * ****************
     * 打包前 是资源的绝对路径 例如: /Users/xuhongzhi/temp/test/config.properties
     * ****************
     * 打包后是定位到jar包的绝对路径加！资源路径
     *      且前面会添加访问协议
     * 例如 ：file:/Users/xuhongzhi/temp/test/path.jar!/config.properties
     */
    public static void getResource() throws IOException {
        String filePath;
        //获取当前线程上下文加载器所属项目的根目录下的config.properties文件， 如果是一个不存在的文件则会报错，存在就返回正常路径
        filePath = Thread.currentThread().getContextClassLoader().getResource("config.properties").getPath();
        System.out.println(filePath);
        //访问项目中的config.properties文件资源  如果是一个不存在的文件则会报错，存在就返回正常路径
        filePath = GetPath.class.getClassLoader().getResource("config.properties").getPath();
        System.out.println(filePath);
        InputStream inputStream = GetPath.class.getClassLoader().getResource("config.properties").openStream();
        OutputStream outputStream = new ObjectOutputStream(System.out);
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
    }

    /**
     * 获取某个类所在的路径,打包前和打包后获取到的信息是不一样的
     * 打包前是类所在运行目录：/Users/xuhongzhi/studen/java8/out/production/java8/（也类似于jar包位置，因为java8是编译之后的文件路径）
     * 打包后是定位到jar包的位置：/Users/xuhongzhi/temp/test/target/path.jar
     */
    public static void getClassPath() throws URISyntaxException {
        String filePath = GetPath.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        System.out.println(filePath);
    }

    /**
     * 获取系统配置重的项目路径 打包前和打包后一致都是项目所在目录
     * 例如jar包/项目在/Users/xuhongzhi/temp/test/target 目录
     *
     * 那么将返回 /Users/xuhongzhi/temp/test/target
     */
    public static void getSysResource() {
        String filePath = System.getProperty("user.dir");
        System.out.println(filePath);
    }


    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        getResourcePath();
//        getResource();
//        getClassPath();
        getSysResource();

    }
}
