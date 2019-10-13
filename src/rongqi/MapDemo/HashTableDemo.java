package rongqi.MapDemo;

import java.util.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HashTableDemo.java
 * @Description TODO
 * @createTime 2019年04月02日 19:39:00
 */
public class HashTableDemo {
    static Map map = new Hashtable();

    public static void put() {
//        map.put(null, "aaa");
//        map.put("aaa", null);
        map.put("aaa","aaa");
    }

    public static void main(String[] args) {
        put();
        System.out.println(map.get("aaa"));
//        System.out.println(map.get(null));
        System.out.println(map.containsKey("aaa"));
        Set setKey = map.keySet();
        System.out.println("======================");
        Iterator iterator = setKey.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
