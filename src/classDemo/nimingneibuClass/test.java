package classDemo.nimingneibuClass;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName test.java
 * @Description TODO
 * @createTime 2019年04月02日 21:24:00
 */
public abstract class test {
    public abstract void sayok();
    private void aaa(){} //这样写 虽然不会报错 但是子类 无法继承 相当于 一个死方法
}
