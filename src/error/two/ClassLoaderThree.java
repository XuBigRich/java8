package error.two;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLClassLoader;

/**
 * @author 许鸿志
 * @since 2022/8/16
 */
//public class ClassLoaderThree extends ClassLoader {
public class ClassLoaderThree  extends  ClassLoader{
    private String director;//被加载类所在的目录

    public ClassLoaderThree(String director) {
        this.director = director;
    }

    public ClassLoaderThree(String director, ClassLoader parent) {
        this.director = director;
    }

//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        return null;
//    }

    /**
     * 此findClass方法是父类的loadClass方法 调用的
     * 在调用父类方法loadClass方法时 需要传入 类的完全限定名classLoader.loadClass("cn.piao888.Demo");
     *
     * @param name 传入的是类的完全限定名
     * @return 类的对象
     */
    @Override
    protected Class<?> findClass(String name) {
        try {
            //把类名转化为目录
            String file = director + File.separator + name.replace('.', '/') + ".class"; //这个地方就是把完全限定名的.变成/（系统识别的）
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buf = new byte[1024];
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int len = -1;
            while ((len = fileInputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            byte[] data = outputStream.toByteArray(); //读取到的字节码的二进制数字
            fileInputStream.close();
            outputStream.close();
            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return null;
    }
}