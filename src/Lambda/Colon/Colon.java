package Lambda.Colon;


import Lambda.whyuse.Employee;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/*
 * 一、 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用方法引用
 *         （可以理解为方法引用是Lambda表达式的另一种表达形式）
 * 主要有三种语法格式：
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 * 注意：Lambda体中调用方法的参数列表与返回值类型 要与函数式接口中抽象方法的参数列表和返回值类型一样
 *      如果第一个参数是实例方法的调用者，第二个参数是实例方法的参数时 就可以用类::实例方法名(Class::method)
 * 二、构造函数引用：
 *     格式：
 *     ClassName::new
 * 三、数组引用
 *     Type::new
 * */
public class Colon {
    public static void test1() {
        //最开始实现Consumer接口 需要使用Lamdba
        Consumer<String> con = (A) -> System.out.println(A);
        //把输出流提取出来 改造为这样的
        PrintStream ps1 = System.out;
        Consumer<String> con1 = (a) -> ps1.println(a);
        //使用实例方法名调用实例方法
        PrintStream ps2 = System.out;
        Consumer<String> con2 = ps2::println;
        //改造到一起最后成为
        Consumer<String> con3 = System.out::println;
        con2.accept("abcdef");
    }

    public static void test2() {
        Employee emp = new Employee();
        Supplier<String> sup = () -> emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        Integer num = sup2.get();
        System.out.println(num);
    }

    //类::静态方法名
    public static void test3() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        com.compare(2, 3);
        Comparator<Integer> com1 = Integer::compare;
        com1.compare(2, 3);
    }

    //类::实例方法名
    public static void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        //如果第一个参数是实例方法的调用者，第二个参数是实例方法的参数时 就可以用类::实例方法名(Class::method)
        BiPredicate<String, String> bp2 = String::equals;


    }

    //=======================================================================================================
    //构造器引用（构造函数引用）
    public static void test5() {
        //Lambda写法
        Supplier<Employee> sup = () -> new Employee();
        Employee emp = sup.get();
        //构造器引用
        Supplier<Employee> sup2 = Employee::new;//问：Employee的下面有两个构造器，那么 构造器引用是引用的 哪个  答:无参的 因为参数列表要与接口 参数列表一致
        Employee emp2 = sup.get();
        System.out.println(emp);
        System.out.println(emp2);

        Function<Integer, Employee> function = (x) -> new Employee(x);
        Function<Integer, Employee> function2 = Employee::new;
        Employee employee = function.apply(1);
        Employee employee2 = function2.apply(2);
        System.out.println(employee);
        System.out.println(employee2);

        BiFunction<String, Integer, Employee> biFunction = Employee::new;
        Employee f = biFunction.apply("许鸿志", 18);
        System.out.println(f);
    }

    //构造器数组引用（构造函数引用）
    public static void test6() {
        Function<Integer, String[]> fun = x -> new String[x];
        Function<Integer, String[]> fun1 = String[]::new;
        String[] strings = fun.apply(5);
        String[] strings2 = fun.apply(10);
    }

    public static void main(String[] args) {
        test1();
//            test2();
//        test5();
    }
}
