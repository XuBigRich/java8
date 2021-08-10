package classLoad.URLClassLoaderDemo;

import com.sun.jndi.toolkit.url.Uri;
import sun.misc.Launcher;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 使用URLClassLoader 来加载本地或者时网络上的 Class类
 * <p>
 * 探究 不同URLClassLoader对象，在双亲委派机制下，是否重合一致（不一致）
 */
public class UseURLClassLoder {
    /**
     * 访问本地的class文件
     */
    public void callLocalhost() throws IllegalAccessException, InstantiationException, ClassNotFoundException, MalformedURLException {
        //这里是将java包保存在D盘的demo目录下
        File file = new File("D://demo/");
        //File对象获得 通过URI 对象
        URI uri = file.toURI();
        //将URI对象转换为URL对象
        URL url = uri.toURL();
        //因为URLClassLoader只识别URL数组，那么给他丢个数组进去
        URL[] urls = {url};
        ClassLoader classLoader = new URLClassLoader(urls);
        System.out.println("父类加载器：" + classLoader.getParent());//默认父加载器
        //成功被加载
        Class<?> aClass = classLoader.loadClass("cn.piao888.Demo");
        //成功被初始化
        aClass.newInstance();
    }

    /**
     * 访问远程服务器的class文件
     */
    public void callnet() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL url = new URL("http://piao888.cn/examples");
        //因为URLClassLoader只识别URL数组，那么给他丢个数组进去
        URL[] urls = {url};
        ClassLoader classLoader = new URLClassLoader(urls);
        System.out.println("父类加载器：" + classLoader.getParent());//默认父加载器
        //成功被加载
        Class<?> aClass = classLoader.loadClass("cn.piao888.Demo"); // 所有的.在findClass阶段将被转化为/
        //成功被初始化
        aClass.newInstance();
    }

    public static void useURLClassLoader() throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        URL url = new URL("file://D:\\workspace\\java8\\out\\production\\java8");
        URL[] urls = {url};
        ClassLoader classLoader = new URLClassLoader(urls);
        //设置classLoader对象 为上下文加载器
        Thread.currentThread().setContextClassLoader(classLoader);
        //如果注释掉下面的代码，只会打印一个file://D:/workspace/java8/out/production/java8
        //如果让他初始化classLoad.URLClassLoaderDemo.UseURLClassLoder这个类,则会加载很多引用的jar包，所以会加载更多东西
        //---------------------------------------------------------------------------------------
//        Class<?> aClass = classLoader.loadClass("classLoad.URLClassLoaderDemo.UseURLClassLoder"); // 所有的.在findClass阶段将被转化为/
//        UseURLClassLoder useURLClassLoder= (UseURLClassLoder)aClass.newInstance();
//        useURLClassLoder.learnURLs();
        //----------------------------------------------------------------------------------------

    }

    //URLClassLoader.getURLs 方法就是用来获取这个加载器 加载过的所有项目
    public void learnURLs() throws MalformedURLException {
        URL url = new URL("http://piao888.cn/examples");
        URL[] urls = {url};
        //新建一个新的类加载器对象,也是URLClassLoader 类型的,并查看他是否会影响上下文加载器
        ClassLoader urlClassLoader = new URLClassLoader(urls);
        //并查看urlClassLoader所加载过的项目地址
        if (urlClassLoader instanceof URLClassLoader) {
            URL[] urlList = ((URLClassLoader) urlClassLoader).getURLs();
            Enumeration<URL> baseUrls = new Vector(Arrays.asList(urlList)).elements();
            //感觉这像一个原始的迭代器
            while (baseUrls.hasMoreElements()) {
                System.out.println("urlClassLoader: " + baseUrls.nextElement());
            }
        }


        //上下文加载器 并查看contextClassLoader所加载过的项目地址
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //获取上下文加载器加载过的jar包
        if (contextClassLoader instanceof URLClassLoader) {
            URL[] urlList = ((URLClassLoader) contextClassLoader).getURLs();
            Enumeration<URL> baseUrls = new Vector(Arrays.asList(urlList)).elements();
            //感觉这像一个原始的迭代器
            while (baseUrls.hasMoreElements()) {
                System.out.println("contextClassLoader: " + baseUrls.nextElement());
            }
        }
    }

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        UseURLClassLoder useURLClassLoder = new UseURLClassLoder();
        //访问远程jar包
//        useURLClassLoder.callLocalhost();
//        useURLClassLoder.callnet();
        //访问本地jar包
        useURLClassLoader();
        useURLClassLoder.learnURLs();
    }
}
