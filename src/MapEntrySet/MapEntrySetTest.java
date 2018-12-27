package MapEntrySet;

import java.util.*;

public class MapEntrySetTest {
    private static void method(Map<Integer,String> map){
        Set entrySet=map.entrySet();//entrySet()方法返回 反应map键值的映射关系,存储在set集合中
        Iterator it=entrySet.iterator();//使用迭代器获得每一个映射关系
        while(it.hasNext()){
            System.out.println(it);//返回set内存地址
            Map.Entry me=(Map.Entry) it.next();// 映射关系 类型  为map.Entry类型，是一个接口类型
            System.out.println(me);
            System.out.println(me.getKey()+":::"+me.getValue());
        }
    }
    public static void main(String[] args) {
            Map<Integer,String> map=new HashMap<Integer, String>();
            map.put(1,"许");
            map.put(2,"鸿");
            map.put(3,"志");
            method(map);
    	}
}
