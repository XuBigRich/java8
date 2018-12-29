package clone.kaobei;
//所有被拷贝的类 都需要 添加 一个Cloneable接口 即使这个接口没东西 但是 如果不添加的话 会被抛出异常
//关于：Cloneable 接口，可以看到它其实什么方法都不需要实现。对他可以简单的理解只是一个标记，是开发者允许这个对象被拷贝
public class Staff implements Cloneable{
    private String name;
    private int age;
    private Boss boss;  //类的实例对象的引用

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Boss=" + boss +
                '}';
    }
}