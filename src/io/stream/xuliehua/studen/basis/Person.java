package io.stream.xuliehua.studen.basis;

import java.io.Serializable;
/*
* 只有实现了Serializable和Externalizable接口的类的对象才能被序列化。
* */
public class Person implements Serializable {
    //s​e​r​i​a​l​V​e​r​s​i​o​n​U​I​D​:​ ​字​面​意​思​上​是​序​列​化​的​版​本​号​，凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量（即使不写，在编译的时候 也会自动生成一个。）
    /*
    * 如果 去掉 序列化版本号 去反编译同一个 文件 也会成功  但 Person  被修改过（如：添加一个 age属性）再去反编译 则 会抛出java.io.InvalidClassExceptio 异常
    * 因为  这个类 再去 接收 反编译文件 用的是 原来默认生成的 序列化版本号 与 修改后默认生成的 序列化版本号 不同
    * */
//    private static final long serialVersionUID = 1234567888854L;
    private String name;
    private String sex;
    private int old;
    private int age;

    public Person(String name, String sex,int age) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }
    /*public Person(String name, String sex,int old) {
        this.old = old;
        this.name = name;
        this.sex = sex;
    }*/



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", old=" + old +
                '}';
    }

}
