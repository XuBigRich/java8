package jicheng.mianshiti.team2;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName This.java
 * @Description   测试 证明了 Super()与 this（）  都必须要放在构造函数的 第一位   所以 super和this不可以同时出现
 *          //java拒绝在 构造函数中 产生递归调用\
 *          //使用this可以 调用 自己 的构造函数
 * @createTime 2019年04月23日 10:40:00
 */
public class This extends Super{
    public This(){
       // this("s");    //java拒绝在 构造函数中 产生递归调用
        this(1);
        System.out.println("无参构造函数被调用");
    }

    public This(int i){
        System.out.println(i);
    }
    public This(String a){
//        super();
        this();
        super.a=a; // this()与super()有 第一位的规则 但是 super. 与 this. 没有放在第一位的规则
        System.out.println(a+"有参构造函数 被调用");
    }
    public static void main(String[] args) {
        This aa=new This("1");
    }
}
