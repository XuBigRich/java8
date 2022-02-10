package Lambda.whyuse;

import Lambda.use.Count;

import java.util.*;
/*
* lambda表达式：
*   lambda表达式事实上 就是生成一个对象，这个表达式整体就是一个接口的实现对象。
*
* 看完所有方法后看：
*       优化方法思路：众多方法中 “输出方法” 冗余度最高，优化方法就是  合并输出方法
*       思路  把判断方法从 输出 中分离出来  建立一个统一的 输出方法（也就是说 保证输出循环中 所有的 成员都符合判断条件）
*       关于(策略设计模式) 与 匿名类（包括Lambda） 他们各有优略；当 需要多次重复使用 判断条件时 使用策略设计模式，当 偶尔使用一两次时使用匿名类(Lambda )
*       通常情况下Lambda需要搭配一个公共的 方法
* */
public class SortTest {
   static List<Employee> employees= Arrays.asList(
            new Employee("张三",18,999999.99),
            new Employee("李四",38,888888.88),
            new Employee("王五",50,666666.66),
            new Employee("赵六",16,333333.33)
    );
    public static void test1(){
        //生成一个匿名内部类对象
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, 02);
            }
        };
        TreeSet<Integer> ts=new TreeSet<>(com);
    }
    //Lambda表达式
    public static void test2(){
        //生成一个lambda表达式对象 【(o1,o2) ->Integer.compare(o1, 02)】 【】里面的其实是一个对象
        Comparator<Integer> com=(o1,o2) ->Integer.compare(o1, 02);
        TreeSet<Integer> ts=new TreeSet<>(com);
    }
    //为什么使用Lambda表达式
    //===========================================================================================
    //常规 写法     工具（众多方法 包含众多冗余的输出  和判断）
    //=============================================================================================
    //需求:获取当前公司中大于35岁的员工信息
    public static List<Employee> filterEmployees(List <Employee> list){
        List<Employee> list1=new ArrayList<>();
        for(Employee employee:list){
            if(employee.getAge()>35){
                list1.add(employee);
            }
        }
        return list1;
    }
    //需求获取当前公司中 员工工资大于5000的员工信息
    public static List<Employee> filterEmployees2(List <Employee> list){
        List<Employee> list1=new ArrayList<>();
        for(Employee employee:list){
            if(employee.getSalary()>5000){
                list1.add(employee);
            }
        }
        return list1;
    }
    //=======================================================================================
     //设计模式(策略设计模式)      理解：事实上 新建一个类,这个类只是改了一下 查询等条件  减少了 前期大量的准备工作，减少了代码的冗余 但是 每次有新的需求都要新建立一个类
            //工具（一个接口，众多实体类,一个公用的输出方法）
    //=====================================================================================
    //通过这种设计模式  可以在不用改变方法的状态下 去实现 各种查询条件（因为实现这种接口的方式 有很多）
    public static List<Employee> filterEmployees(List <Employee> list,MyPredicate<Employee> mp){
        List<Employee> emps=new ArrayList<>();
        for (Employee employee: list){
            if(mp.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }
    //=========================================================================================================
        //匿名内部类     工具（一个接口，一个匿名内部类,一个公用的输出方法）
    //======================================================================================================
    //用年龄作为条件
    public static List test3(){
        List list=filterEmployees(employees,new MyPredicate<Employee>(){
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()>35;
            }
        });
        return list;
    }
    //用工资作为条件
    public static List test4(){
        List list=filterEmployees(employees,new MyPredicate<Employee>(){
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary()>5000;
            }
        });
        return list;
    }
    //======================================================================================================
        //用Lambda方式      工具（一个接口，一个Lambda表达式,一个公用的输出方法）
    //============================================
    //用年龄作为条件
    public static List test5(){
        return filterEmployees(employees,(employee -> employee.getAge()>35));
    }
        //用工资作为条件
     public static List test6(){
        return filterEmployees(employees,(employee -> employee.getSalary()>5000));
     }

       public static void main(String[] args) {
            //用年龄作为条件(常规手法)
           System.out.println(filterEmployees(employees));
           //用工资作为条件(常规手法)
           System.out.println(filterEmployees2(employees));

           //用年龄作为条件(策略设计模式)
           List a=filterEmployees(employees,new FilterEmployeeByAge());
           System.out.println(a);
           //用工资作为条件(策略设计模式)
           List b=filterEmployees(employees,new FilterEmployeeBySalary());
           System.out.println(b);
           //用年龄作为条件(匿名内部类)
           System.out.println(test3());
           //用工资作为条件 (匿名内部类)
           System.out.println(test4());
          // 用年龄作为条件（Lambda）
           System.out.println(test5());
           //用工资作为条件（Lambda）
           System.out.println(test6());
    }
}

