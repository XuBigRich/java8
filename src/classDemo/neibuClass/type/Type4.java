package classDemo.neibuClass.type;

/**
 *局部内部类 —— 在方法中定义的内部类
 */
public class Type4{
      public void outMethod(){
             final int beep=0;
             class Inner{
                   //使用beep
             }
             Inner in=new Inner();
      }
}

