package Class.proxy;

import java.lang.reflect.*;

/**
 * 直接使用接口生成一个代理类，这个代理类必定有且只有一个，含参构造方法，这个含参构造方法接收一个InvocationHandler类型的类作为参数
 * @Author： hongzhi.xu
 * @Date: 2021/2/18 上午9:03
 * @Version 1.0
 */
public class GetProxyClass {
    public Class getStarProxy() {
        Class c = null;
        Class proxyClass = Proxy.getProxyClass(this.getClass().getClassLoader(), Star.class);
        c = proxyClass;
        return c;
    }

    public Constructor getConstructor(Class c)  {
        Constructor constructor = null;
        try {
            constructor = c.getConstructor(InvocationHandler.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }

    public Star newObject(Constructor c) {
        Star star = null;
        try {
            star = (Star) c.newInstance((InvocationHandler) (proxy, method, args) -> null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return star;
    }

    public static void main(String[] args)  {
        GetProxyClass getProxyClass = new GetProxyClass();
        Class c = getProxyClass.getStarProxy();
        Constructor constructor= getProxyClass.getConstructor(c);
        Star s = getProxyClass.newObject(constructor);
        s.sing("hh");
    }
}
