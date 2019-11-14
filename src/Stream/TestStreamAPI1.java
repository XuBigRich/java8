package Stream;

import Lambda.whyuse.Employee;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/*
 * 一、Stream的三个操作步骤
 *   1.创建Stream
 *
 *   2.中间操作：
 *              多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！而在种植操作时一次性全部处理，称为“惰性求值”
 *
 *   3.终止操作（最终操作）
 * */
public class TestStreamAPI1 {
    //中间操作
    /*
    * 筛选与切片
    * filter--接收Lambda,从流中排除某些元素
    * limit--截断流，使其元素不超过给定数量
    * skip（n）--跳过元素,返回一个扔掉前面n个元素。若流中元素不足n个，则返回一个空流，与limit(n)互补
    * distinct--筛选，通过流所生成的元素的hashCode()和equals（）去除重复元素
    * */
    static List<Employee> employees= Arrays.asList(
            new Employee("张三",18,999999.99),
            new Employee("李四",38,888888.88),
            new Employee("王五",50,666666.66),
            new Employee("赵六",16,333333.33),
            new Employee("田七",16,333333.33),
            new Employee("田七",16,333333.33)
    );
    //内部迭代：迭代操作有Stream API自己完成
    public static void test1(){
     //中间操作:不会执行任何操作
   Stream<Employee> s= employees.stream()
                                  .filter(e-> {
                                      System.out.println("Stream API的中间操作");
                                      return e.getAge() > 35;
                                  });
     //终止操作:一次性执行全部内容  即“惰性求值”
//     s.forEach(System.out::println);
     //注：若无终止操作，中间操作将不会进行  验证方法 注释掉 s.forEach(System.out::println)
    }
    //外部迭代:自己完成迭代操作（自己写迭代方法）
    public static void test2(){
        Iterator<Employee> it=employees.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void test3(){
       Stream<Employee> stream= employees.stream()
                                         .filter((x)->x.getSalary()>5000)
                                         .limit(2);
       stream.forEach(System.out::println);

    }
    //跳过+去重 （若出现去重不成功 有可能是没有重写hashcode和equals方法 因为去重 原理就是流所生成的hashcode和equals方法判断 是否重复）
    public static void test(){
        Stream<Employee> stream= employees.stream()
                .filter((x)->x.getSalary()>5000)
                .skip(2) //跳过前两个
                .distinct();//去重
        stream.forEach(System.out::println);
        

    }
    /*
    * 映射
    * */
    public static void test5(){
    	
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
    public static void main(String[] args) {
//    		test1();
//        test2();
//        test3();
        test();
        test5();
    	}
}
