package jicheng.zhuanhuan;

/**
 * 测试转型后 方法和参数 使用的分别是 父类还是子类的
 *
 * 结论：子类转型父类后 访问的成员变量是父类的  访问的方法是子类的
 * @Author： hongzhi.xu
 * @Date: 2020/10/14 11:31 上午
 * @Version 1.0
 */
public class Sub  extends Parent{
    public int i=2;
    @Override
    public void say(){
        System.out.println("我是子类");
    }

    public static void main(String[] args) {
        Parent parent =new Sub();
        parent.say();
        Parent parent1 =(Parent)new Sub();
        parent1.say();
        //访问的成员变量是父类的  访问的方法是子类的
        System.out.println( parent.i);
    }
}
