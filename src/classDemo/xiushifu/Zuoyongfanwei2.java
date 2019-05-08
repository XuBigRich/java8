package classDemo.xiushifu;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Zuoyongfanwei2.java
 * @Description    若 frendly 类中拥有 一个 public 内部类
 * 那这个 public 内部类 也只能在 本包 在优先new 外部类的情况下才能被访问
 * 如果 有个 并列的 public 类 那么 这个  类  的 文件 必须改为 public类 的名字
 * 如果没有 则无所谓
 * @createTime 2019年04月18日 18:03:00
 */
class Zuoyongfanwei2 {
      Zuoyongfanwei2(){
         System.out.println("Zuoyongfanwei2");
     }
     public class Tt{
          Tt(){
              System.out.println("frendly 里面的public 类");
          }
    }
}
/*public class Tt{
    Tt(){
        System.out.println("frendly 里面的public 类");
    }
}*/
