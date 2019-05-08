package Static;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ZlStatic.java
 * @Description TODO
 * @createTime 2019年04月19日 11:51:00
 */
public class ZlStatic extends FlStatic {
    static int s;
    //public  int aaa(){  //证明static 的父类方法不能被 重写
    public static int aaa(){  //但可以 声明一个(名字一样)属于自己类的静态 方法
        System.out.println("aaa被执行");
        return  1;
    }

    public static void main(String[] args) {

        ZlStatic zlStatic=new ZlStatic();
        ZlStatic zlStatic2=new ZlStatic();  //初始化两次 却 只输出 一次静态块
                                            // 因为  静态 块与 静态属性 将在第一次初始化后常驻内存 且属于类    第二次 就不会被初始化了
        zlStatic2.aaa();   //输出aaa  子类静态方法被执行 说明 子类可以声明一个(名字一样)属于自己类的静态 方法 并 优先调用  自己的 方法
                            //  但是idea没有出现重写 注解 根据12行代码 也证明 子类 不可以重写static方法

        FlStatic.bbb();  //输出2    给父类参数v打一个标记 增加1
        zlStatic.bbb();  //输出3 证明了 static 方法可以被子类 继承   子类直接去调用 父类  bbb方法



    }
}
