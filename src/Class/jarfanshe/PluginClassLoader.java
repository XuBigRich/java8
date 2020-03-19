package Class.jarfanshe;

import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class PluginClassLoader extends URLClassLoader {
    public PluginClassLoader(){
        super(new URL[] {});
    }
    public void addURLFile(URL file) {
        //将指定的URL附加到URL列表中以搜索类和资源。
        addURL(file);
    }
}