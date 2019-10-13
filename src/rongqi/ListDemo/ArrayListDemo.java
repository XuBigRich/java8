package rongqi.ListDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class ArrayListDemo {
    static List<Integer> list=new ArrayList();
    static List<Employee> employees= Arrays.asList(
            new Employee("张三",18,999999.99),
            new Employee("李四",38,888888.88),
            new Employee("王五",50,666666.66),
            new Employee("赵六",16,333333.33)
    );
    public static List add(){
        list.add(1);
        list.add(2);
        list.add(3);
        return list;
    }
    public static List remove(){
        list.remove(0);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(employees);///若想使用这样的方式输出list值需要 搭配toString方法

        Iterator iterator= add().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=============================");
        Iterator iterator2= remove().iterator();
      //  System.out.println(remove().get(0));  // 对 rongqi.ListDemo 迭代完成 后 再对List进行操作 会报错java.util.ConcurrentModificationException
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    	}
}
