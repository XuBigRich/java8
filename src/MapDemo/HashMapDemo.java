package MapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HashMapDemo.java
 * @Description TODO
 * @createTime 2019年04月02日 19:39:00
 */
public class HashMapDemo {
    static Map map=new HashMap();
    public static void put(){
        map.put(null,"aaa");
        map.put("aaa",null);
    }
    public static void fg(){
        map.put(null,null);  //这样操作 会覆盖掉  原先 null中的  aaa值
    }
    public static void main(String[] args) {
        put();
        System.out.println(map.get("aaa"));
        System.out.println(map.get(null));
        System.out.println(map.containsKey(null));
        Set setKey=map.keySet();
        System.out.println("======================");
        Iterator iterator=setKey.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(map.get(null));
        System.out.println("===========================================");
        //===================================================
        fg();
        System.out.println(map.get("aaa"));
        System.out.println(map.get(null));
        System.out.println(map.containsKey(null));
        Set seKey=map.keySet();
        System.out.println("======================");
        Iterator iterato=seKey.iterator();
        while (iterato.hasNext()){
            System.out.println(iterato.next());
        }
        System.out.println(map.get(null));
    }
}
