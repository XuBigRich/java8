package Class.proxy.cglib;

import Class.proxy.LiuDeHua;
import Class.proxy.Star;
import Class.proxy.StarProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 1、 CGlib是一个强大的,高性能,高质量的Code生成类库。它可以在运行期扩展Java类与实现Java接口。
 * 2、 用CGlib生成代理类是目标类的子类。
 * 3、 用CGlib生成 代理类不需要接口
 * 4、 用CGLib生成的代理类重写了父类的各个方法。
 * 5、 拦截器中的intercept方法内容正好就是代理类中的方法体
 */
public class CglibProxy implements MethodInterceptor
{
    // 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
    public Object CreatProxyedObj(Class<?> clazz)
    {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }

    /**
     *
     * @param arg0  目标对象代理类的实例
     * @param arg1  代理实例上调用父类方法的Method实例
     * @param arg2  传给父类方法的参数
     * @param arg3  使用它调用父类方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable
    {
        // 这里增强
        System.out.println("收钱");

        return arg3.invokeSuper(arg0, arg2);
    }
    public static void main(String[] args)
    {
        int times = 1000000;

        Star ldh = new LiuDeHua();
        StarProxy proxy = new StarProxy(ldh);

        long time1 = System.currentTimeMillis();
        Star star = (Star)proxy.CreatProxyedObj();
        long time2 = System.currentTimeMillis();
        System.out.println("jdk创建时间：" + (time2 - time1));

        CglibProxy proxy2 = new CglibProxy();
        long time5 = System.currentTimeMillis();
        Star star2 = (Star)proxy2.CreatProxyedObj(LiuDeHua.class);
        long time6 = System.currentTimeMillis();
        System.out.println("cglib创建时间：" + (time6 - time5));

        long time3 = System.currentTimeMillis();
        for (int i = 1; i <= times; i++)
        {
            star.sing("ss");

            star.dance("ss");
        }
        long time4 = System.currentTimeMillis();
        System.out.println("jdk执行时间" + (time4 - time3));

        long time7 = System.currentTimeMillis();
        for (int i = 1; i <= times; i++)
        {
            star2.sing("ss");

            star2.dance("ss");
        }

        long time8 = System.currentTimeMillis();

        System.out.println("cglib执行时间" + (time8 - time7));
    }

}
