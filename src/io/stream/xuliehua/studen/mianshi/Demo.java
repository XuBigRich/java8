package io.stream.xuliehua.studen.mianshi;

import java.io.Serializable;

/**
 * 问题：
 * 阅读Shape和Circle两个类的定义。在序列化一个Circle的对象circle到文件时，下面那个字段会被保存到文件中。
 * 答案是：
 * radius
 * 解释：
 * 因为父类 没有继承Serializable  所以 序列化不会保存父类属性状态，其属性也将赋值为默认值，故name不会被保存
 * color被transient 声明  而transient 就是标示忽略序列化的关键字。 故color不会被保存
 * type 属于静态变量，独立于类 与类并列。不属于Circle对象 。故Circle不会被保存
 *
 * 扩展：
 *  如果子类实现了Serializable接口， 父类没有实现，那么父类方法一定要拥有无参的构造方法，否则在反序列化的时候 会报错。
 *
 *
 * @Author： hongzhi.xu
 * @Date: 2020/11/25 下午8:26
 * @Version 1.0
 */
public class Demo {
    class Shape {
        public String name;
    }

    class Circle extends Shape implements Serializable {
        private float radius;
        transient int color;
        //发现了一个秘密 就是内部类不可以又内部生命
//        public static String type="Circle";
    }
}
