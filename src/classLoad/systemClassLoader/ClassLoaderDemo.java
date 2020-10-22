package classLoad.systemClassLoader;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * 系统原生的类加载器 有三个
 * 根加载器：
 * ExtClasLoader加载器（扩展类加载器），用于加载（lib/ext)目录的加载器
 * DNSNameService加载器（系统类加载器），用于加载当前工程所有类的加载器（当前工程默认加载器）
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        //Object类加载器
        ClassLoader classLoader=Object.class.getClassLoader();
        System.out.println("Object的类加载器"+classLoader);
        //使用ExtClassLoader 的类加载器    负责加载<JAVA_HOME>\jre\lib\ext目录下的类库或者系统变量"java.ext.dirs"指定的目录下的类库
        String s=System.getProperty("java.ext.dirs");
        System.out.println(s);
            //其中DNSNameService就是其中的一个类
        ClassLoader classLoader1= DNSNameService.class.getClassLoader();
        System.out.println("DNSNameService的类加载器"+classLoader1);
    }
}
