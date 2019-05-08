package finalDemo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ZlFinal.java
 * @Description TODO
 * @createTime 2019年04月19日 13:31:00
 */
public class ZlFinalMethod extends FinalMethod {
    int a=2;  // final 属性 可以被 子类 拥有一个  名字一样的 final
    public void say(int a){
        System.out.println(a);  //可以说是重载父类方法，也可是说没重载
            // （因为 观念不同
        //              观念一：重载发生在 一个类中  所以 这个 不属于重载父类方法
        //              观念二：既然子类继承了 父类 全部可视方法 那么 即使发生在子类 也属于 重载
        //      总结 ：总而言之 子类可以 拥有 非父类 private ,final声明的方法 的方法名
        //      ）
    }

    public static void main(String[] args) {
        ZlFinalMethod zlFinalMethod=new ZlFinalMethod();
        System.out.println( zlFinalMethod.a);
    }
}
