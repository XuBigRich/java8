package interfaceAndAbstractDemo.shixianAbstract;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Man.java
 * @Description TODO
 * @createTime 2019年05月06日 11:03:00
 */
public class Man extends Person {
    @Override
    public void eat() {
        System.out.println("子类必须实现抽象父类的抽象方法");
    }

    /*@Override      //重写 不可以只重写访问权限
    protected void sex(String judge) {
        System.out.println(judge);
    }*/

    @Override
    public void sex(String judge) {
        System.out.println(judge);
    }

        public static void main(String[] args) {
        Man man=new Man();
        man.judge();
    }
}
