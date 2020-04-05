package Class.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarProxy implements InvocationHandler {
    private Object target;
    public StarProxy(Object target){
        this.target=target;
    }
    public void setTarget(Object target)
    {
        this.target = target;
    }
    /**
     * 该方法负责集中处理动态代理类上的所有方法调用。
     * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     *
     * @param proxy  代理类实例
     * @param method 被调用的方法对象
     * @param args   调用参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //此处传入的是代理类实例 所以 转化会报错
//        LiuDeHua liuDeHua=(LiuDeHua)proxy;
     //   System.out.println(liuDeHua.fans);

        // 这里可以做增强
        System.out.println("收钱");
        Object result = method.invoke(target, args);
        return result;
    }

    /**
     * 方法CreatProxyedObj返回的对象才是我们的代理类，
     * 它需要三个参数，前两个参数的意思是在同一个classloader下通过接口创建出一个对象，
     * 该对象需要一个属性，也就是第三个参数，它是一个InvocationHandler
     * @return  返回需要的代理类
     */
    public Object CreatProxyedObj() {
        /*
         * Proxy类是由JDK提供的一个类  其三个参数意义
         * 1. 获取目标类的类加载器
         * 2. 获取目标类实现的接口
         * 3. 目标类需要一个InvocationHandler 对象
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
