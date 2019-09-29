package Changdu;

import java.util.ArrayList;
import java.util.List;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName Demo.java
 * @Description 此示例 示范了 如何得到 数组  String  rongqi.ListDemo  长度的 方法或参数
 * @createTime 2019年04月23日 11:31:00
 */
public class Demo {
    public static void main(String[] args) {
        String a="aaa";
        System.out.println(a.length());
        int [] b={1,2};
        System.out.println(b.length);
        List c=new ArrayList(2);
        System.out.println(c.size());
    }
}
