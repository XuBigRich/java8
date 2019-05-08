package shortDemo;

import java.math.BigDecimal;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName shortDemo.java
 * @Description TODO
 * @createTime 2019年04月01日 20:09:00
 */
public class shortDemo {
    static short s1=1;
    static short s2=2;
    static float f1=0.3f;
    static int i1=1;
    static Double i2=1.0;
    static Double c1=0.8;
    static BigDecimal i=new BigDecimal(i2.toString());
    static BigDecimal c=new BigDecimal(c1.toString());

    public static void main(String[] args) {
        System.out.println(s1);
        float a=s1+=s2;
        System.out.println(a);
        System.out.println(0.3*1==0.3);
        System.out.println(1.0-0.8);
        System.out.println(i.subtract(c).doubleValue());
        System.out.println(1.1+0.8);
        System.out.println(1.1*0.9);
        System.out.println(606.3/3000);

    }
}
