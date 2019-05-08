package Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CollectionDemo.java
 * @Description TODO
 * @createTime 2019年04月11日 22:15:00
 */
public class CollectionDemo {
     List list=new ArrayList();
     ArrayList arrayList=new ArrayList();
     public static void main(String[] args) {
     		CollectionDemo collectionDemo=new CollectionDemo();
     		collectionDemo.list.add("11");
         collectionDemo.list.remove(0);
         collectionDemo.list.get(0);
         System.out.println( collectionDemo.list.get(0));
         collectionDemo.arrayList.add("222");
         System.out.println(collectionDemo.arrayList.size());
     	}
}
