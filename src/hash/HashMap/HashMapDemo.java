package hash.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用hashcode 可以准确方便的定位。
 *
 * @Author： hongzhi.xu
 * @Date: 2020/11/18 下午2:42
 * @Version 1.0
 */
public class HashMapDemo {

    public Map map = new HashMap();

    public void put(String key, String value) {
        System.out.println(map.put(key, value));
    }

    public void get(String key) {
        map.get(key);
    }

    public static void main(String[] args) {
        HashMapDemo demo = new HashMapDemo();
        demo.put("许", "鸿志");
        demo.get("许");
        demo.put("许", "大富");
        demo.get("许");
    }
}
