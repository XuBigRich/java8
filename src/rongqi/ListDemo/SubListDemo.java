package rongqi.ListDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证  SubList是深复制 还是浅复制， 他俩的顺序还不能反 ，否则会出现 异常
 *
 * @Author： hongzhi.xu
 * @Date: 2023/4/4 4:45 下午
 * @Version 1.0
 */
public class SubListDemo {
    public static void read() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);

        List sub = integers.subList(0, 3);
        //Exception in thread "main" java.util.ConcurrentModificationException
//        integers.add(1,666);
        sub.add(1, 666);
        System.out.println(integers);
        System.out.println(sub);
    }

    public static void isnull() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);

        List sub = integers.subList(0, 3);
        integers = null;
        System.out.println(integers);
        System.out.println(sub);
    }

    public static void main(String[] args) {
//        read();
        isnull();
    }
}
