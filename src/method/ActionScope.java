package method;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ActionScope.java
 * @Description TODO
 * @createTime 2019年03月26日 11:02:00
 */
/*
 * 变量的方法块 有多大 他的 有效 作用域 就有多大
 * */

public class ActionScope {
    String a="aa";
    public static void main(String[] args) {
        ActionScope actionScope=new ActionScope();
        String c="aaa";  //方法中声明的变量 只存在于方法中
        {
            actionScope.a="bbb";
            System.out.println(actionScope.a);
            String d="aaaa";  //方法块中 声明的变量只存在于 方法块 中  脱离方法块 就失效了
        }

        System.out.println(actionScope.a);
        System.out.println(c);
        //        System.out.println(d);
    	}
}
