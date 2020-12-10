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
     * 该方法由生成的代理类去执行，
     * 该方法负责集中处理动态代理类上的所有方法调用。
     * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
     *
     * @param proxy  代理类实例
     * @param method 被调用的方法对象
     * @param args   调用参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //此处传入的是代理类实例 所以 转化会报错
//        LiuDeHua liuDeHua=(LiuDeHua)proxy;
     //   System.out.println(liuDeHua.fans);

        // 这里可以做增强 （方法执行前）
        System.out.println("收钱");
        //调用方法需要通过被代理类对象与所调用方法 进行初始化 并执行 返回Object
        Object result=method.invoke(target,args);
        // 这里可以做增强 （方法执行后）
        System.out.println("跑路");
        return result;
    }

    /**
     * 可以找地方给他挪出来hhhh
     * 方法CreatProxyedObj返回的对象才是我们的代理类，
     * 它需要三个参数，前两个参数的意思是在同一个classloader下通过接口创建出一个对象，
     * 该对象需要一个属性，也就是第三个参数，它是一个InvocationHandler
     * @return  返回需要的代理类
     */
    public Object CreatProxyedObj() {
        /*
         * Proxy类是由JDK提供的一个类
         * newProxyInstance，的返回值是一个代理类（方法代理）
         *  其三个参数意义
         * 1. 获取目标类的类加载器
         * 2. 获取目标类实现的接口（了解被代理类有哪些方法）
         * 3. 目标类需要一个InvocationHandler 对象（也就是当前实现类） 用以规范 回调的invoke方法
         * 重点：
         * 新生成的代理类，根据被代理类的实现接口，
         *                  StarProxy这个类作为构造方法。
         *                  Proxy类作为父类（Proxy存在一个InvocationHandler为接口的属性对象，其实例就是当前类）
         *  执行时，因为代理类继承自Proxy类所以，Proxy类会根据不同方法的调用，给invoke方法传入不同的Mothod值和参数
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
