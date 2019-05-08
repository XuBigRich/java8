package classDemo.neibuClass;

import classDemo.C;

public class Test {
    public static void main(String[] args) {
    		A a=new A();
    		A.B b=new A().new B(); //由此可以看出 若想生成内部类对象 需先生成外部类对象 ，再生成 内部类对象
            a.i=1;
            b.j=2;
        System.out.println(b.funB());//这个地方之所以输出2是因为i变量 是 a引用的 对象，跟b没有关系
        A.B b1= a.new B(); //由此可以看出 若想生成内部类对象 需先生成外部类对象 ，再生成 内部类对象
        b1.j=2;
        System.out.println(b1.funB());//这个地方可以正常输出3是因为 b1引用的对象是再a对象基础上new出来的B类 所以b1对象可以使用a的属性值
        /*
        * 总结
        * 内部类可以随意使用外部类所定义的成员变量
       * */
//        C c=new C();
        C.D d=new C.D();
    	}

}
