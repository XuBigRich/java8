package io.stream.xuliehua.studen.inheritance;

import java.io.Serializable;

/**
 * 父类属性是否被序列化取决于 父类是否添加了Serializable 接口，
 * 如果父类没有添加Serializable 接口 但是子类添加了Serializable 接口 那么通常情况下
 * 那么 在存在无参构造函数的情况下，Person的属性 为默认值 String 为null  int 为0
 * 若不存在无参构造函数，那么会在反序列化时 报错
 *
 */
public class Person {

    protected String name;
    protected int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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
}
