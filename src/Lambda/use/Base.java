package Lambda.use;

import java.util.Arrays;
import java.util.function.Function;

/**
 * 什么是lambda表达式，lambda表达式的建立
 * <p>
 * lambda 其实也可以是强制转换的
 *
 * @Author： hongzhi.xu
 * @Date: 2022/1/29 2:53 下午
 * @Version 1.0
 */
public class Base {

    //建立一个Count 数组 ，放入两个lambda对象
    //注意第一个 关于lambda表达式的强制类型转换
    public Count[] counts = {(Count<Integer, Integer>) (x, y) -> x * y, (x, y) -> x.equals(y)};

    //lambda表达式中 调用外部遍历为什么是final类型的
    public void testFinal() {
        // 引用y 指向的是 "你好"，这个字符串对象的内存地址
        final String y = "你好!";
        //1.因为Java是一个值传递，y引用的是 "你好" 这个对象的 内存地址，
        //2.如果改变了 y的引用地址，y指向新的 对象（假设 指向世界）。 那么 lambda对象中的 y 就与外部的y 内存地址指向不一致了
        //3. 如果不一致，就导致 外部的y 指向 "世界"，而lambda对象里面的y 依然指向 "你好"，这样就出问题了，所以y不可以 改变 必须为final
        Shift shift = (x) -> x + y;
        System.out.println(shift.getValue("lambda "));
    }

    /**
     * 及联表达式
     * 柯里化:把多个参数的函数，转换为只有一个参数的函数
     * 柯里化目的： 把函数标准化
     */
    public void curry() {
        Function<Integer, Function<Integer,  Integer>> function1 = x -> y -> x + y ;
        Integer num = function1.apply(2).apply(3);
        System.out.println(num);
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function2 = x -> y -> z -> x + y + z;
        Integer num2 = function2.apply(2).apply(3).apply(4);
        System.out.println(num2);
    }

    public static void main(String[] args) {
        Base base = new Base();
        Arrays.stream(base.counts).forEach(a -> System.out.println(a.ccl(1, 2)));
        //学习为什么 lambda表达式调用 内部变量需要是final类型的
        base.testFinal();
        base.curry();
    }
}
