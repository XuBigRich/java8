package Lambda.coreInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
* java8内置四大核心接口
*
* Consumer<T>:消费型接口
*   void accept(T t)
* Supplier<T>:供给型接口
*   T get();
* Function<T,R>:函数型接口
*   R apply(T t);
* Predicate<T>:断言型接口
*   boolean test(T t);
* */
public class Lambda {
    //Consumer<T>:消费型接口
    public void test1(){
        happy(2223.16,a -> System.out.println("钱被消费了"+a+"元") );
    }
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
    //Supplier<T>:供给型接口
    public List<Integer> vvv(Supplier<List<Integer>> supplier){
        return supplier.get();
    }
    public void test2(){
       ArrayList<Integer> arrayList =new ArrayList();
       arrayList.add(1);
       arrayList.add(2);
        List a=vvv(()->arrayList);
        System.out.println(a);
    }
    //Function<T，R>：函数型接口
    public static void main(String[] args) {
        Lambda lambda=new Lambda();
        lambda.test1();
        lambda.test2();
    	}
}
