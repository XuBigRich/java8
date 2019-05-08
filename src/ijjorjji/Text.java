package ijjorjji;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Text.java
 * @Description TODO
 * @createTime 2019年02月26日 16:14:00
 */
public class Text {
   public static void main(String[] args) {
       Demo demo=new Demo();
       demo.jji();
       demo.ijj();
       int i=0;
       System.out.println(i=i++);  // 一值 出现 0 很搞笑  因为 产生的 新值 被i覆盖掉了
       System.out.println(i=i++);
       System.out.println(i=i++);

       System.out.println(i=++i);  // 先相加 再赋值 就不会出现覆盖掉 的 情况
       System.out.println(i=++i);
       System.out.println(i=++i);

       System.out.println("================");
       int g=0;
       g++;
       System.out.println(g);  //这样可以出现 正常的 1   2  因为  ++i与i++差异只体现在赋值期间
       g++;
       System.out.println(g);

   	}

}
