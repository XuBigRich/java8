package method;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName EquAndDd.java
 * @Description TODO
 * @createTime 2019年03月26日 10:58:00
 */
/*
 * 面试题：
 * String s = new String("Hello")与String s = "hello"的区别？
 *
 * == 比较的是引用类型，是地址值是否相同
 * equals 比较的是引用类型，默认是比较地址值，而String类重写了equals方法，比较的是内容是否相同。
 *
 */
public class EquAndDd {
    String str=new String("good");
    String nb=new String("1111");
    String nx=new String("1111");
    String xb="1111";
    String aa="1111";
    public static void main(String[] args) {
    		EquAndDd equAndDd=new EquAndDd();

        System.out.println(equAndDd.nb==equAndDd.str);
        System.out.println(equAndDd.nb.equals(equAndDd.str));

        System.out.println(equAndDd.nb==equAndDd.nx);
        System.out.println(equAndDd.nb.equals(equAndDd.nx));

        System.out.println(equAndDd.nb==equAndDd.xb);
        System.out.println(equAndDd.nb.equals(equAndDd.xb));

        System.out.println(equAndDd.aa==equAndDd.xb);
        System.out.println(equAndDd.aa.equals(equAndDd.xb));
    	}
}
