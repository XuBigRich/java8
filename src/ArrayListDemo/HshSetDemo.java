package ArrayListDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 许鸿志
 * @since 2021/7/26
 */
public class HshSetDemo {
    public static void compare() {
        Set a = new HashSet();
        a.add(1);
        a.add(2);
        Set b = new HashSet();
        b.add(2);
        b.add(1);
        System.out.println(a.equals(b));
    }

    public static void main(String[] args) {
        compare();
    }
}
