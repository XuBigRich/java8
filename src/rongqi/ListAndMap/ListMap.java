package rongqi.ListAndMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ListMap.java
 * @Description TODO
 * @createTime 2019年03月09日 17:32:00
 */
public class ListMap {
    public List l=new ArrayList(5);
    public Map a=new HashMap();
    public Map b;
    public Map c;
    public void text(){
        a.put("aaa",123);
        l.add(a.keySet());
        System.out.println(l.get(0));
    }
    public static void main(String[] args) {
    		ListMap listMap=new ListMap();
    		listMap.text();
    	}
}
