package hash.HashMap.shunxu;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void test() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println(map.keySet());
    }
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

       for(int i=0;i<1000;i++)test(); // 输出键的顺序
    }
}
