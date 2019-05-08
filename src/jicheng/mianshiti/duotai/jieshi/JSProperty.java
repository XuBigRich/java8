package jicheng.mianshiti.duotai.jieshi;

/*
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description 解释 父类属性与子类属性关系
 * @createTime 2019年04月25日 17:17:00
 */

public class JSProperty {
    static class A{
        public int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    static class B extends A{
        public B(){
            setValue(5);
            System.out.println(this.value);
            System.out.println(super.value);  // 可以看出  子类 与 父类 用的 是 同一个 属性 的 value
        }
    }

    public static void main(String[] args) {
        B b=new B();
    }
}
