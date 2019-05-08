package List;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName VectorDemo.java
 * @Description TODO
 * @createTime 2019年04月02日 19:08:00
 */
public class VectorDemo {
    public static List list=new Vector();
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
        //  System.out.println(remove().get(0));  // 对 List 迭代完成 后 再对List进行操作 会报错java.util.ConcurrentModificationException
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
