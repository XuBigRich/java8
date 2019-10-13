package rongqi.ListDemo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * @author admin
 * @version 1.0.0
 * @ClassName LinkListDemo.java
 * @Description LinkList 的增删 速度要快于 ArrayList  查询速度 慢于ArrayList
 * @createTime 2019年04月02日 19:08:00
 */
public class LinkedListDemo {
    public static List<Integer> list = new LinkedList();

    public static List add() {
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }

    public static List remove() {
        list.remove(1);
        return list;
    }

    public static void main(String[] args) {

        Iterator iterator= add().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Iterator iterator2 = remove().iterator();
        //  System.out.println(remove().get(0));  // 对 rongqi.ListDemo 迭代完成 后 再对List进行操作 会报错java.util.ConcurrentModificationException
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
