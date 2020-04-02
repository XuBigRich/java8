package classLoad.URLClassLoaderDemo;

import com.sun.jndi.toolkit.url.Uri;
import sun.misc.Launcher;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 使用URLClassLoader 来加载本地或者时网络上的 Class类
 */
public class UseURLClassLoder {
    /**
     * 访问本地的class文件
     */
    public void callLocalhost() throws IllegalAccessException, InstantiationException, ClassNotFoundException, MalformedURLException {
        //这里是将java包保存在D盘的demo目录下
        File file=new File("D://demo/");
        //File对象获得 通过URI 对象
        URI uri=file.toURI();
        //将URI对象转换为URL对象
        URL url=uri.toURL();
        //因为URLClassLoader只识别URL数组，那么给他丢个数组进去
        URL[] urls={url};
        ClassLoader classLoader=new URLClassLoader(urls);
        System.out.println("父类加载器："+classLoader.getParent());//默认父加载器
        //成功被加载
        Class<?> aClass=classLoader.loadClass("cn.piao888.Demo");
        //成功被初始化
        aClass.newInstance();
    }

    /**
     * 访问远程服务器的class文件
     */
    public void callnet() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL url=new URL("http://piao888.cn/examples");
        //因为URLClassLoader只识别URL数组，那么给他丢个数组进去
        URL[] urls={url};
        ClassLoader classLoader=new URLClassLoader(urls);
        System.out.println("父类加载器："+classLoader.getParent());//默认父加载器
        //成功被加载
        Class<?> aClass=classLoader.loadClass("cn.piao888.Demo");
        //成功被初始化
        aClass.newInstance();
    }
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        UseURLClassLoder useURLClassLoder=new UseURLClassLoder();
        useURLClassLoder.callLocalhost();
        useURLClassLoder.callnet();
    }
}
