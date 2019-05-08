package leixingzhuanhuan.qiangzhileixingzhuanhuan;

import fanxing.STTeacher;
import fanxing.Teacher;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName qz.java
 * @Description TODO
 * @createTime 2019年04月12日 07:41:00
 */
public class Qz {
    public static void main(String[] args) {
        double a=2.0;
        Double c=a; //关于基本类型 被谁接收的 就是谁的 类型 与 类类型
        System.out.println(c.getClass().getName());
        Integer d=(int)a;  //强转只能是基本类型的转换 如  int double short byte char  等 这些类型
        System.out.println(d.getClass().getName());  //被强转后 遵循 谁接收的 就是 谁的 类型 类类型 （如果用包装类接收）
        //=======================================================
        Teacher s=new STTeacher();
        System.out.println(s.getClass().getName());  //此为对照 在对象转换中 不会因为谁接收 而转换类类型  但会转换类型
        System.out.println("=====================================");
        System.out.println((int)(char)(byte)1);
    }
}
