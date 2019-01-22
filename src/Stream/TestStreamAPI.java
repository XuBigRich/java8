package Stream;

import Lambda.whyuse.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
* 一、Stream的三个操作步骤
*   1.创建Stream
*
*   2.中间操作
*
*   3.终止操作（最终操作）
* */
public class TestStreamAPI {

    public static void test1(){
        //通过Collection系列集合提供的stream() 或 parallelStream()
        List<String> list=new ArrayList<>();
        Stream<String> Stream1=list.stream();
        list.parallelStream();

        //通过Arrays中的静态方法Streat()获取数组流
        Employee[] employees=new Employee[10];
        Stream<Employee> stream2=Arrays.stream(employees);

        //通过Stream类中静态方法of()
        Stream<String> stream3=Stream.of("aaa","bbb","ccc");

        //创建无限流(无穷尽)
        //迭代
        //seed UnaryOperator
       Stream<Integer> stream4= Stream.iterate(0,x->x+2);
       //从stream流中 取前十条数据 进行forEach 输出
        stream4.limit(10).forEach(System.out::println);
        //生成

        Stream<Double> stream5= Stream.generate(()->Math.random());
        stream5.limit(5).forEach(System.out::println);
    }
    public static void main(String[] args) {
    		test1();
    	}
}
