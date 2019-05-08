package jicheng.mianshiti.duotai;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MSTDT.java
 * @Description 多态经典面试题
 * @createTime 2019年04月25日 10:41:00
 */
/*
* PS:super不能出现在静态方法里，因为静态方法都是通过类调用的，不能接收this指针
* */
public class MSTDT {
    public static void main(String[] args) {
        System.out.println(new B().getValue());

    }
    static class A{

        protected int value;   //10 11  out:22   16 17
        public A(int v){
            setValue(v);  //他第一次调用  调用的 是 子类   方法    因为父类 setValue被隐藏  除非 明确使用 super调用
        }
        public void setValue(int value){
            this.value=value;
        }
        public int getValue(){
            try {
                value ++;
                return value;
            }finally {
                this.setValue(value);   //this 是调用当前对象,而再本题中 只产生了子类一个对象, 故 此处this调用的是子类中的setValue.
                System.out.println(value);  //第一次调用 输出 的是 22  但返回的是11  但经过 set赋值 value实际值是22
                                                //提示 53行 中间 有 操作改变了  value值  value 变为 16（实际值）  ++ 后 变为17 并返回  之后 15行输出 为 17
                                            //第二次调用 输出 是 34  返回时  17  set后
            }
        }

    }
    static class B extends A{
        /* value getValue()并没有  显示出来， 且 父类的setValue被子类隐藏。
        在初始化子类时，除非子类明确使用super.setValue(super可以调用被隐藏的 属性和方法)，否则被子类隐藏的setValue无法被调用 （不管子类中还是父类中）
         例如第17行 调用的是47行setValue，而非父类第19行setValue  (19行setValue隐藏了this  this.setValue)
         */
        public B(){
            /*建议精读*/
          /* JVM 上 new 一个对象包含 NEW 指令与 INVOKE_SPECIAL 指令调用                 （调用构造函数），
            前者完成创建对象的操作，                                                    （new的时候 就已经产生了对象）
            后者调用新创建出来对象的 <init> 方法（也就是用来初始化）。                   （后者只是 选择这个对象的初始化方式）
            当在子类的 constructor 里调用 super(xxx) 的时候只是调用了父类的 <init> 方法   （所以 子类初始化的时候 并没有 产生父类对象 只是调用了  构造方法）
                */
            super(5);  // 调用父类 构造函数   父类 value被设置为 10   ，但子类与父类公用一个value 所以 父类value 即 子类value
            setValue(getValue()-3);    //此报错 不影响执行 为 父类 方法 //此时 子类value 为0 getValue后 为
        }
        public void setValue(int value){
            super.setValue(2*value);

        }

    }
}
