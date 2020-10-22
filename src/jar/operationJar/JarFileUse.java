package jar.operationJar;

import sun.net.www.ParseUtil;

import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * url 设置路径一定要添加协议！！！
 * 访问jar包中的资源
 * 内容讲解了 三种方法获取指定jar包的资源
 * 1.通过jdk提供的JarFile与JarEntry获取 jar包下的指定资源（最简单）
 * 2.类加载器获取  jar包下的指定资源 （注意区分URLClassLoader,与Appl）
 * 3.
 *
 * @Author： hongzhi.xu
 * @Date: 2020/10/10 2:52 下午
 * @Version 1.0
 */
public class JarFileUse {

    /**
     * 使用jdk提供的读取指定jar包访问方法
     *
     * @throws IOException
     */
    public static void readFromJar() throws IOException {
        String jarPath = "/Users/xuhongzhi/temp/test/target/path.jar";
        String file = "config.properties";
        //还可以访问制定的类文件
//        String file="getPath/GetPath.class";
        JarFile jarFile = null;
        try {
            //获取到指定jar包文件
            jarFile = new JarFile(jarPath);
            //访问jar包中的指定文件
            JarEntry jarEntry = jarFile.getJarEntry(file);
            InputStream input = jarFile.getInputStream(jarEntry);
            OutputStream outputStream = new ObjectOutputStream(System.out);
            byte[] bytes = new byte[1024];
            while (input.read(bytes) != -1) {
                outputStream.write(bytes);
            }
        } catch (IOException e) {
            throw e;
        } finally {
        }
    }

    /**
     * 获取指定jar包下的配置文件 通过类加载器的方式
     * 但是莫名其妙的访问到了自己项目下的config.properties
     * 由此可以证明类加载器是从本项目中过去的
     * 所以算是访问失败了
     *
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void accessJarProperties() throws ClassNotFoundException, IOException {
        String urlString = "file:/Users/xuhongzhi/temp/test/target/path.jar";
        URL url = new URL(urlString);
        URL[] urls = {url};
        URLClassLoader classLoader = new URLClassLoader(urls);
        InputStream inputStream = classLoader.getResourceAsStream("config.properties");
        OutputStream outputStream = new ObjectOutputStream(System.out);
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
        Class service = classLoader.loadClass("getPath.GetPath");
        Method[] methods = service.getDeclaredMethods();
        for (Method method : methods) {
//            System.out.println(method.getName());
        }
        //获取不在本项目下的类的类加载器，其资源路径依然使用的是本路径下的类加载器路径。
        String s = service.getClassLoader().getResource("").getPath();
        System.out.println(s);
        //获取这个类下的配置文件
        InputStream inputStream1 = service.getClassLoader().getResource("config.properties").openStream();
        OutputStream outputStream1 = new ObjectOutputStream(System.out);
        while (inputStream1.read(bytes) != -1) {
            outputStream1.write(bytes);
        }
        System.out.println();
    }

    /**
     * 继续使用类加载器访问指定jar包下的配置文件
     *
     * @throws IOException
     */
    public static void readFromJarByClassLoader() throws IOException {
        String urlString = "file:/Users/xuhongzhi/temp/test/target/path.jar";
        URL fileUrl = new URL(urlString);
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{fileUrl}, null);
        InputStream inputStream = urlClassLoader.getResourceAsStream("config.properties");
        OutputStream outputStream = new ObjectOutputStream(System.out);
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes);
        }
        System.out.println();
    }


    /**
     * 尝试通过文件流访问jar包里面的文件，失败了！
     * 因为文件流对于路径识别不支持 中间含感叹号 path.jar!config.properties
     * 而jar包与文件的分割就是使用了感叹号，所以这个方法是不可行的
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void getJarResourceStream() throws IOException, URISyntaxException {
        String path = "file:/Users/xuhongzhi/temp/test/target/path.jar!/config.properties";
        FileInputStream fileInputStream = new FileInputStream(path);
        OutputStream fileOutputStream = new ObjectOutputStream(System.out);
        byte[] bytes = new byte[1024];
        while (fileInputStream.read(bytes) != -1) {
            fileOutputStream.write(bytes);
        }
    }

    /**
     * 通过URL访问 这样发访问依然失败
     *
     * @throws IOException
     */
    public static void getJarResourceStream2() throws IOException {
        String path = "file:/Users/xuhongzhi/temp/test/target/path.jar!/config.properties";
        URL url = new URL(path);
        InputStream inputStream = url.openStream();
        OutputStream fileOutputStream = new ObjectOutputStream(System.out);
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            fileOutputStream.write(bytes);
        }
    }

    /**
     * 继续通过URL访问 这次使用单独的jar包连接 访问url中的内容成功了
     * <p>
     * 所以要访问jar包里面的内容资源，需要先与jar包建立连接，再访问jar包中的内容
     *
     * @throws IOException
     */
    public static void getJarResourceStream3() throws IOException {
//        String path = "file:/Users/xuhongzhi/temp/test/target/path.jar";
//        URL url = new URL(path);
//        URL jarUrl=new URL("jar", "", -1, url + "!/");
//        URL moduleUrl = new URL(jarUrl, ParseUtil.encodePath("config.properties", false));

        URL moduleUrl = new URL("jar", "", -1, "file:/Users/xuhongzhi/temp/test/target/path.jar!/config.properties");
        JarURLConnection urlConnection = (JarURLConnection) moduleUrl.openConnection();
        OutputStream fileOutputStream = new ObjectOutputStream(System.out);
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            fileOutputStream.write(bytes);
        }

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, URISyntaxException {
//        readFromJar();
        accessJarProperties();
//        readFromJarByClassLoader();
//        getJarResourceStream();
//        getJarResourceStream2();
//        getJarResourceStream3();
    }
}
