package error.two;

import sun.misc.Launcher;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author 许鸿志
 * @since 2022/8/16
 */
public class Test {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException, ClassNotFoundException {
//        String target = Test.class.getResource("").getPath() + "Target";
//        System.out.println(target);
        //如果在本包下 该类会先被 AppClassLoader 加载器加载一遍
//        String target = "D://workspace/java8/out/production/java8";
        String target = "D:\\test";
        String def = "D:\\";
        File file = new File(target);
        ClassLoaderOne classLoaderOne = new ClassLoaderOne(target);
        ClassLoaderTwo classLoaderTwo = new ClassLoaderTwo(target);
        ClassLoaderThree classLoaderThree = new ClassLoaderThree(def);
        //loadClass寻找 类时 ,无关路径,他会先已有的路径中去查找,找到了 他就会去加载, 后来的路径 ,重名了 也不会吧原来的替换掉
        classLoaderOne.loadClass("error.two.Target");
        classLoaderTwo.loadClass("error.two.Target");
        classLoaderThree.loadClass("error.two.Target1");
        Class<?> target1 = Class.forName("error.two.Target", true, classLoaderOne);
        //查看这个类由谁加载
        System.out.println(target1.getClassLoader());
        Class<?> forName2 = Class.forName("error.two.Target", true, classLoaderTwo);

        //查看这个类由谁加载
        System.out.println(forName2.getClassLoader());

        Class<?> forName3 =  Class.forName("error.two.Target1", true, classLoaderThree);

        //查看这个类由谁加载
        System.out.println(forName3.getClassLoader());
    }
}
