package Class.jarfanshe;

import cn.piao888.Proctocol;

import java.io.IOException;
import java.net.*;

/**
 * 初始化jar包
 * URLClassLoader：自SecureClassLoader，支持从jar文件和文件夹中获取class，继承于classload，
 * 加载时首先去classload里判断是否由bootstrap classload加载过，1.7 新增实现closeable接口，
 * 实现在try 中自动释放资源，但扑捉不了.close()异常
 */
public class JarInstance {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String pluginUrl =  "jar:file:D:\\workspace\\java8\\resources\\gcthrift.jar!/";  //  be careful
        URL url = new URL(pluginUrl);
        PluginClassLoader pluginClassLoader=new PluginClassLoader();
        pluginClassLoader.addURLFile(url);

        Class<?> forName = Class.forName("cn.piao888.cg.thrift.ProessceService", true, pluginClassLoader);
        Proctocol ins = (Proctocol)forName.newInstance();
        System.out.println(ins.registerProcessor().getProcessorName());
    }
}
