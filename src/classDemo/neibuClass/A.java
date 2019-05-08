package classDemo.neibuClass;

public class A {
    A(){
        System.out.println("判断是否调用A无参构造函数");
    }
     int i;
    class B{
        int j;
        //int i;   //若内部类不存在i则默认使用外部类的i （A.this.i），若存在默认使用自己的i
         int funB(){
            int result=i+j;
            return result;
        }
    }
}
