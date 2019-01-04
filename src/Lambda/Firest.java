package Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
* 一.Lambda 表达式的基础语法：Java8中引入了一个新的操作符"->"，该操作符称为箭头操作符或Lambda操作符
*                            箭头操作符Lambda表达式拆分成两部分；
*  左侧:Lambda 表达式的参数列表
*  右侧:Lambda 表达式中所需执行的功能,即Lambda体
*
* 语法格式一:无参数，无返回值
*           ()-> System.out.println("hello Lambda!");
* 语法格式二:有一个参数,并且无返回值
*           (x)-> System.out.println(x);
* 语法格式三:若只有一个参数，小括号可以省略不写
*           x-> System.out.println(x);
* 语法格式四:有两个及以上参数,有返回值，并且Lambda体中有多条语句
*       Comparator<Integer> com=(x,y)->{
*            System.out.println("函数式接口");
*            return Integer.compare(x,y);
*             };
* 语法格式五:若Lambda体中只有一条语句,return和大括号都可以省略不写
*            (x, y) -> Integer.compare(x, y);
* 语法格式六:Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器可以通过上下文推断出，数据类型。（类型推断）
*           (Integer x, Integer y) -> Integer.compare(x, y);
*  总结：
*       一：  上联：左右遇一括号省
*             下联：左侧推断类型省
*             横批:能省则省
*       二: Lambda表达式 需要"函数式接口"的支持
*               函数式接口：接口中只有一个抽象方法的接口，称之为函数式接口。可以使用注解@FunctionalInterface修饰 可以检查是否为 函数式接口;
* */
public class Firest {
    //第一种 无参数 无返回值
    public static void test1(){
        int num=0; // jdk1.7前 ，必须添加一个final前缀。现在不需要了添加了默认就是final。(匿名函数使用变量必须为final
        //常规写法
    Runnable r=new Runnable() {
        @Override
        public void run() {
            System.out.println("hellow world!"+num);
        }
    };
    //Lambda写法
        Runnable r2=()-> System.out.println("hello Lambda!");
        r2.run();
        r.run();
    }
    //第二种 有参数 无返回值
    public static void test2(){
        Consumer<String> con=(x)-> System.out.println(x);
        con.accept("许鸿志");
    }
    public static void test3(){
        Comparator<Integer> com=(x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    public static void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }
    public static void test5() {
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
    }
    //类型推断
    public static void test6(){
        String[] strs={"aaa","bbb","ccc"}; //根据前文 String[] 集合可以推断出 这是个String类型的 数组
       // String [] strss;
       // strss={"aaa","bbb","ccc"};  //分开后因为没有上下文 所以无法推断Strss内的对象是什么参数类型额；
        List<String> list=new ArrayList<>();//其通过类型推断省略了  后面ArrayList<>中<String>

    }
    public static void main(String[] args) {
        test1();
        test2();
        }
}
