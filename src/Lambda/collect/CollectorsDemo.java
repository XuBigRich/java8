package Lambda.collect;

import Lambda.whyuse.Employee;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 收集
 */
public class CollectorsDemo {
    static List<Employee> employeeList;

    static {
        Employee employee1 = new Employee("hongzhi.xu", 21, 3960);
        Employee employee2 = new Employee("许渣渣", 22, 5000);
        Employee employee3 = new Employee("许渣渣", 23, 6000);
        employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
    }

    //转为List
    public static void test1() {
        List<String> names = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
    }

    //转为Set去重
    public static void test2() {
        Set<String> names = employeeList.stream().map(Employee::getName).collect(Collectors.toSet());
        names.forEach(System.out::println);
    }

    //转为HashSet
    public static void test3() {
        HashSet<Integer> names = employeeList.stream().map(Employee::getAge).collect(Collectors.toCollection(HashSet::new));
        names.forEach(System.out::println);
    }

    //计算List中个数总和
    public static void test4() {
        Long count = employeeList.stream().collect(Collectors.counting());
        System.out.println(count);
    }

    //计算List中Employee对象 工资的 平均值
    public static void test5() {
        Double avg = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
    }

    //计算List中Employee对象 工资的总和
    public static void test6() {
        Double sum = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
    }

    //计算List中Employee对象 工资最高的那个
    public static void test7() {
        Optional<Double> maxSalary = employeeList.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compare));
        /*此方法较为繁琐*/
        Optional<Employee> maxSalaryEmployee = employeeList.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        /*一次精简*/
//        Optional<Employee> maxSalary = employeeList.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        /*最精简*/
//        Optional<Employee> maxSalary = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(maxSalary.get());
        System.out.println(maxSalaryEmployee.get().getSalary());
    }
    public static void test8(){
        String str=employeeList.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(str);
    }
    public static void main(String[] args) {
        test1();
        System.out.println("===============================================");
        test2();
        System.out.println("===============================================");
        test3();
        System.out.println("===============================================");
        test4();
        System.out.println("===============================================");
        test5();
        System.out.println("===============================================");
        test6();
        System.out.println("===============================================");
        test7();
        System.out.println("===============================================");
        test8();
    }
}
