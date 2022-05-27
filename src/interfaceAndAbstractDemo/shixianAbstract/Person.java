package interfaceAndAbstractDemo.shixianAbstract;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Person.java
 * @Description TODO
 * @createTime 2019年05月06日 10:56:00
 */
public abstract class Person {
    public abstract void eat();

    //静态方法不能由fang'fa'ti方法体
    /*public abstract void move(){
        System.out.println("aaa");
    }*/

    public  void move(){
        System.out.println("子类可以不用必须实现 父类的 非抽象方法发");
    }

    public void sex(String judge){
        System.out.println("女生"+judge);
    }

    public void judge(){
        sex("怎么可能");
    }

    /**
     * 测试通过Person.test() 查看能否直接执行
     */
    public static void test(){
        System.out.println("我是抽象类中的静态方法，我能否被直接执行？");
    }
}
