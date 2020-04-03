package classLoad.hostClassLoader;


/**
 * 此Demo探讨了 三个问题
 *  1.双亲委派机制的 实现
 *  2.绕过双亲委派机制的报错
 *  3.热加载
 * 热加载其实就是一个类可以被重复加载
 */
public class HostClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //这里借用一下自定义类加载器
        MyFileClassLoader classLoader=new MyFileClassLoader("d:/demo");
        MyFileClassLoader classLoader1=new MyFileClassLoader("d:/demo",classLoader);
        //加载两次不报错 是因为双亲委派机制 检测到这个类已经被我这个加载器加载过了 所以直接返回了 被加载的类对象
        Class c1=classLoader.loadClass("cn.piao888.Demo");
        System.out.println(c1.hashCode());
        Class c2=classLoader.loadClass("cn.piao888.Demo");
        System.out.println(c2.hashCode());

        //直接绕过loadClass的双亲委托机制 调用findClass 直接自己加载
        Class c3=classLoader1.findClass("cn.piao888.Demo");
        System.out.println(c3.hashCode());
        //第二次直接绕过双亲委托机制的检测 调用findClass 会报错，因为 这个类已经被jvm加载为类对象了再次加载判定不安全 于是报错
        Class c4=classLoader1.findClass("cn.piao888.Demo");
        System.out.println(c4.hashCode());

    }
}
