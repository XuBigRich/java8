package ArrayListDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CollectionDemo.java
 * @Description TODO
 * @createTime 2019年04月11日 22:15:00
 */
public class ArrayListDemo {
    List list = new ArrayList();
    ArrayList arrayList = new ArrayList();

    /**
     * 增删查
     */
    public static void option() {
        ArrayListDemo collectionDemo = new ArrayListDemo();
        collectionDemo.list.add("11");
        collectionDemo.list.get(0);
        System.out.println(collectionDemo.list.get(0));
        collectionDemo.list.remove(0);
        collectionDemo.arrayList.add("222");
        System.out.println(collectionDemo.arrayList.size());
    }

    public static void compare() {
        List a = new ArrayList();
        a.add(1);
        a.add(2);
        List b = new ArrayList();
        b.add(2);
        b.add(1);
        System.out.println(a.equals(b));
    }

    public static void main(String[] args) {
        option();
        compare();
    }
}
