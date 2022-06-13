package Class.proxy.cglib.sourceCode;

import net.sf.cglib.proxy.Enhancer;

/**
 * 与JDK动态代理相比，cglib可以实现对一般类的代理而无需实现接口。在上例中通过下列步骤来生成目标类Target的代理类：
 *
 * 创建Enhancer实例
 * 通过setSuperclass方法来设置目标类
 * 通过setCallback 方法来设置拦截对象
 * create方法生成Target的代理类，并返回代理类的实例
 */
public class Test {
    public static void main(String[] args) {
//    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\code");
         //实例化一个增强器，也就是cglib中的一个class generator
        Enhancer eh = new Enhancer();
         //设置目标类
        eh.setSuperclass(Target.class);
        // 设置拦截对象
        eh.setCallback(new Interceptor());
        // 生成代理类并返回一个实例
        Target t = (Target) eh.create();
        t.f();
        t.g();
        //cglib会创建一个子类
        System.out.println(t.getClass());
        //若想获得原本的类，需要调用superclass
        System.out.println(t.getClass().getSuperclass());
    }
}