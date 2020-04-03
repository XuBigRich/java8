package classLoad.CustomClassLoader;

import java.io.*;

/**
 * 自定义类步骤  本地方法类
 *  ClassLoader 类中 三个重要方法与作用
 *      loadClass   主要实现双亲委派模式
 *      findClass   主要实现类的发现与加载为二进制
 *      defineClass 主要实现类的二进制转化为Class对象
 * 1.继承ClassLoader类
 * 2.覆盖findClass方法
 */
public class MyFileClassLoader extends ClassLoader{
    private String director;//被加载类所在的目录
    public MyFileClassLoader(String director){
        this.director=director;
    }

    public MyFileClassLoader(String director, ClassLoader parent){
        super(parent);
        this.director=director;
    }

    /**
     * 此findClass方法是父类的loadClass方法 调用的
     * 在调用父类方法loadClass方法时 需要传入 类的完全限定名classLoader.loadClass("cn.piao888.Demo");
     * @param name 传入的是类的完全限定名
     * @return 类的对象
     */
    @Override
    protected Class<?> findClass(String name) {
        try {
            //把类名转化为目录
            String file=director+ File.separator+name.replace('.','/')+".class"; //这个地方就是把完全限定名的.变成/（系统识别的）
            FileInputStream fileInputStream=new FileInputStream(file);
            byte[] buf=new byte[1024];
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            int len=-1;
            while((len=fileInputStream.read(buf))!=-1){
                outputStream.write(buf,0,len);
            }
            byte[] data =outputStream.toByteArray(); //读取到的字节码的二进制数字
            fileInputStream.close();
            outputStream.close();
            return defineClass(name,data,0,data.length);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyFileClassLoader classLoader=new MyFileClassLoader("d:/demo");
        Class cls=classLoader.loadClass("cn.piao888.Demo");
        cls.newInstance();
    }

}
