package classDemo.abstrctLear;

/**
 * 静态类可以不实现接口方法
 * 如InterfaceDemo接口里面实际上有一个face方法
 * 但是如果是抽象类 ，那么就可以不去实现这个方法
 * @author 许鸿志
 * @since 2021/9/11
 */
public abstract class InterfaceAbstractDemo implements InterfaceDemo {
    public abstract void say();
}
