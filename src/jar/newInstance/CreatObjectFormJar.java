package jar.newInstance;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 从指定jar包中实例出一个 本项目不存在的类，并执行方法
 * @Author： hongzhi.xu
 * @Date: 2020/10/10 2:54 下午
 * @Version 1.0
 */
public class CreatObjectFormJar {
    /**
     * *****高端操作*******
     * 尝试实例jar包中的某一个类，这个类会引用jar包外的某一个类方法。
     * <p>
     * 准备材料：
     * 1.制作一个jar包 此jar包引用一个不属于本jar包的（在有道笔记有相应的包文件 可自行下载）
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void instantiation() throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String urlString = "file:/Users/xuhongzhi/temp/cn/template/out/tom.jar";
        URL url = new URL(urlString);
        URL[] urls = {url};
        ClassLoader classLoader = new URLClassLoader(urls);
        Class service = classLoader.loadClass("top.piao888.Tom");
        Method[] methods = service.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            //因为是main方法 是静态方法所以不需要传入实例就可以直接运行，但是需要添加参数，
            method.invoke(null, (Object) new String[]{"123", "456"});
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        instantiation();
    }
}
