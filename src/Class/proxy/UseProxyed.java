package Class.proxy;

/**
 * 对Proxy的使用
 * Proxy（jdk类库提供）根据Star接口生成一个实现类，我们称之为C，它就是动态代理类 该类型是 $Proxy+数字 的“新的类型”
 * 所以可以这么认为C代理了InvocationHandler，InvocationHandler代理了我们的类B，两级代理。
 */
public class UseProxyed {
    public static void main(String[] args) {
        //生成一个对象
        Star ldh = new LiuDeHua();
        //生成一个代理生成器 (InvocationHandler) 通过构造方法将被代理的对象放入代理生成器
        StarProxy proxy = new StarProxy(ldh);
        //返回一个代理类  （demo/ProxySubject是一个代理类的实例），该代理类拥有被代理类的所有方法，和StarProxy对象
        Object obj = proxy.CreatProxyedObj();
        //根据接口 转化为相应的 接口实现类（方法代理）
        Star star = (Star)obj;
        //代理类会调用代理类dance方法，代理类的dance方法会调用StarProxy类中的invoke方法
        star.dance("");
    }
}
