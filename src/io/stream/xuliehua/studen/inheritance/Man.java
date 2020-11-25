package io.stream.xuliehua.studen.inheritance;

import java.io.Serializable;

/**
 * 一.父类实现序列化接口,子类自动继承序列化接口,无需显示申明,即子类序列化时会自动序列化父类对象,反序列化没有问题
 * <p>
 * 二.父类没有实现序列化接口,子类实现序列化接口
 * <p>
 * 1.子类可以被序列化,但是父类无法被序列化.无论如何,子类序列化的过程都可以执行,反序列能够成功则要看父类是否有无参构造器.
 * <p>
 * JVM会在反序列化子类时自动调用父类的无参构造器创建父类对象,当父类没有无参构造器时,反序列会失败.
 * <p>
 * 所以,子类实现序列化接口,父类没有实现序列化接口时,必须保证父类有无参构造器,才能让子类正常的序列化反序列化
 * <p>
 * 附上个人测试用代码,父类的无参构造器决定了子类能够反序列化成败
 *
 * @Author： hongzhi.xu
 * @Date: 2020/11/25 下午4:42
 * @Version 1.0
 */

public class Man extends Person implements Serializable {
    private String sex;
    //transient会忽略 属性 将其不被序列化
    private transient int size;
    public static String type = "Circle";



    public Man(String name, int age) {
        super(name, age);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Man.type = type;
    }

    @Override
    public String toString() {
        return "Man{" +
                "sex='" + sex + '\'' +
                ", size=" + size +
                "name='" + super.name + '\'' +
                ", age=" + super.age +
                '}';
    }
}
