package Lambda.Colon;


import Lambda.whyuse.Employee;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    //类::实例方法名   当第一个参数时方法调用者时 可以使用 类::实例方法名(Class::method)
    public static void test4() {

        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        //如果第一个参数是实例方法的调用者，第二个参数是实例方法的参数时 就可以用类::实例方法名(Class::method)
        //注意equals方法 不是静态方法理论上不可以直接使用  类::
        //但是当第一个参数是实例方法 的实例时（发发调用者），第二个参数时实例方法的参数时 可以使用这种形势了
        BiPredicate<String, String> bp2 = String::equals;

        //如果第一个参数是实例方法的调用者,第二个参数是返回值时 可以使用类::实例方法名(Class::method)
        Function<Employee, String> bp1 = e -> e.getName();
        Function<Employee, String> bp3 = Employee::getName;

        //如果第一个参数是实例方法的调用者,第二,三个参数是方法入参，第三四参数时返回值 可以使用类::实例方法名(Class::method)
        FourParameterFunction<Employee, String, String, String> hp4 = (x, y, z) -> x.getInfo(y, z);
        FourParameterFunction<Employee, String, String, String> hp5 = Employee::getInfo;


    }

    //类::实例方法名
    public static void test7() {
        Employee employee1 = new Employee("hongzhi.xu", 21, 3960);
        Employee employee2 = new Employee("许渣渣", 22, 5000);
        Employee employee3 = new Employee("许大富", 23, 6000);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        //一定不为空 需要一个起始值
        Double salaryMaster = employeeList.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
        System.out.println(salaryMaster);
        //可能为空  使用Optional
        Optional<Double> salary = employeeList.stream().map(Employee::getSalary).reduce(Double::sum);
        Optional<Double> salary1 = employeeList.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println(salary.get());
    }

    //=======================================================================================================
    //构造器引用（构造函数引用）
    public static void test5() {
        //Lambda写法
        Supplier<Employee> sup = () -> new Employee();
        Employee emp = sup.get();
        //构造器引用
        Supplier<Employee> sup2 = Employee::new;//问：Employee的下面有两个构造器，那么 构造器引用是引用的 哪个  答:无参的 因为参数列表要与接口 参数列表一致
        Employee emp2 = sup2.get();
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
        test7();
//            test2();
//        test5();
    }
}
