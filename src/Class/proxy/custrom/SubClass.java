package Class.proxy.custrom;

/**
 * 猜想 ，如果继承父类 在子类 写一些增强方法是否可以实现对事务的管理
 *
 *
 * （我觉得这更像是装饰模式，而不是代理）
 */
public class SubClass extends Support {
    //同样的say方法 子方法中的say方法会调用 父类中的say方法 从而达到对父类方法的增强
    public void say(){
        System.out.println("我代理父类");
        super.say();
    }

    public static void main(String[] args) {
        SubClass subClass= new SubClass();
        subClass.say();
    }
}
