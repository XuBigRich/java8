package baozhuanglei;

/**
 * 那么包装类型都有那些
 * 包装类型中0是否可以当除数？ 当除数返回的是什么？
 *
 *
 *       基本类型 与 包装类
 *      boolean —> Boolean
 *       char —> Character
 *       byte—> Byte
 *       short—> Short
 *       long—> Long
 *       int —> Integer
 *       float—> Float
 *       double—> Double

 *
 * @author admin
 * @version 1.0.0
 * @ClassName IntegerDemo.java
 * @Description 包装类 可直接 被 基本类型 接收
 * @createTime 2019年04月23日 11:08:00
 */
public class BaozhuangDemo {
    //包装类的使用
    public static void use(){
        //以 int 与 Integer 为例   其他 包装类 原理 相似
        int a=new Integer(2);
        int b=2;
        Integer c=b;
        System.out.println(c);
    }
    //包装类型的特色 0可以除以0 不会抛出异常，返回值用NaN标表示这个数字不存在
    public static void zeroDividedZero(){

        //Double
        Double doubleZero1=0.0;
        Double doubleZero2=0.0;
        Double b=doubleZero1/doubleZero2;
        //Float
        Float floatZero1=0.0f;
        Float floatZero2=0.0f;
        Float c=floatZero1/floatZero2;
        System.out.println(b+" "+c);
        System.err.println(b.equals(b));
        System.err.println(b.equals(c));
        System.out.println(b==b);
        //Integer  只有浮点类型可以进行0/0 返回NuN （不存在的数字） 整形是不可以进行 0/0的
        Integer intZero1=0;
        Integer intZero2=0;
        Integer a=intZero1/intZero2;
        System.out.println(a);


    }


    public static void main(String[] args) {
        use();
        zeroDividedZero();
    }

}
