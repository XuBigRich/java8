package forDemo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestFor.java
 * @Description TODO
 * @createTime 2019年05月11日 10:16:00
 */

/*
* for循环的表达式一般如下：
for(表达式1;表达式2;表达式3){
    表达式4;
}

执行的顺序为：
1）第一次循环，即初始化循环。
首先执行表达式1（一般为初始化语句），再执行表达式2（一般为条件判断语句），
* 判断表达式1是否符合表达式2的条件，如果符合，则执行表达式4，否则，停止执行，最后执行表达式3.
2）下次的循环：
首先执行表达式2，判断表达式3执行结果是否符合 表达式2的条件；如果符合，继续执行表达式4，
* 否则停止执行，最后执行表达式3.如果往复，直到表达式3不再满足表达式2的条件。

总结：总的来说，执行顺序是一致的，先进行条件判断（表达式2），再执行函数体（表达式4），最后执行表达式3。如此往复，区别在于，条件判断的对象，在第一次判断时，是执行表达式1，初始化对象，后续的判断对象是执行后的结果（表达式3）
* */
public class TestFor {
    static boolean out(char c){
        System.out.println(c);
        return true;
    }


    public static void main(String[] args) {
        int i=0;
        for(out('A');out('B')&&(i<2);out('C')){
            i++;
            out('D');
        }
    }
}
