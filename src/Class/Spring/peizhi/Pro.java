package Class.Spring.peizhi;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class Pro {
    public Properties properties=null;

    {
        if (properties == null) {
            properties = new Properties();
            try {
                InputStream in = new BufferedInputStream(new FileInputStream("D:\\Workspaces\\Java8\\resources\\application.yml"));
                properties.load(in);
                Iterator<String> it=properties.stringPropertyNames().iterator();
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        properties.list(System.out);
    }
    public void aa(String name){
        Object a=properties.get(name);
        StringBuffer nameB=new StringBuffer(name);
        System.out.println(nameB.append(" : ").append(a));
    }

    public static void main(String[] args) {
    		Pro  p=new Pro();
    		p.aa("name");
    		//输出时间戳
        System.out.println(System.currentTimeMillis());
    }

}
