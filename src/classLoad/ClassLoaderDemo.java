package classLoad;

import sun.net.spi.nameservice.dns.DNSNameService;

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
