package Class.proxy.cglib.sourceCode;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Interceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("I am intercept begin");
//Note: 此处一定要使用proxy的invokeSuper方法来调用目标类的方法
        proxy.invokeSuper(obj, args);
        System.out.println("I am intercept end");
        return null;
    }

}
