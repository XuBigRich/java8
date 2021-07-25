package baozhuanglei;

/**
 * 那么包装类型都有那些
 * 包装类型中0是否可以当除数？ 当除数返回的是什么？
 * <p>
 * <p>
 * 基本类型 与 包装类
 * boolean —> Boolean
 * char —> Character
 * byte—> Byte
 * short—> Short
 * long—> Long
 * int —> Integer
 * float—> Float
 * double—> Double
 *
 * @author admin
 * @version 1.0.0
 * @ClassName IntegerDemo.java
 * @Description 包装类 可直接 被 基本类型 接收
 * @createTime 2019年04月23日 11:08:00
 */
public class BaozhuangDemo {
    //包装类的使用
    public static void use() {
        //以 int 与 Integer 为例   其他 包装类 原理 相似
        int a = new Integer(2);
        int b = 2;
        Integer c = b;
        System.out.println(c);
    }

    //char
    public static void learChar() {
        //Character
        Character character = 'a';
        Character character1 = 49;
        Character character2 = '\u7b80';
        System.out.printf("%s,%s,%s", character, character1, character2);
        System.out.println();
    }

    //float的学习  测试是否可以除以0  可以0.0/0.0
    public static void learFloat() {
        Double b = 0.0 / 0.0;
        //Float
        Float floatZero1 = 0.0f;
        Float floatZero2 = 0.0f;
        Float c = floatZero1 / floatZero2;
        System.out.println(b + " " + c);
        System.err.println(b.equals(c));
    }

    //double的学习  测试是否可以除以0  可以0.0/0.0
    public static void learDouble() {
        //Double
        Double doubleZero1 = 0.0;
        Double doubleZero2 = 0.0;
        Double b = doubleZero1 / doubleZero2;
        System.err.println(b.equals(b));
        System.out.println(b == b);
    }


    //Integer  只有浮点类型可以进行0/0 返回NuN （不存在的数字） 整形是不可以进行 0/0的
    public static void learInteger() {
        //Integer  只有浮点类型可以进行0/0 返回NuN （不存在的数字） 整形是不可以进行 0/0的
        Integer intZero1 = 0;
        Integer intZero2 = 0;
        Integer a = intZero1 / intZero2;
        System.out.println(a);
    }

    /**
     * 扩展 中文转unicode编码
     */
    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            //将字符串中的每一个字符取出， 调用Integer toHexString，这个是专门映射字符到16进制的 方法
            String hexB = Integer.toHexString(utfBytes[i]);
            //如果16进制长度小于一个字节 （byte），那就补足为两个字节
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            //  添加/u表示 标识这是一个unicode
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }

    public static void main(String[] args) {
//        use();
//        learChar();
//        learFloat();
//        learDouble();
//        learInteger();
//        System.out.println(Integer.toHexString(' '));
        char a='\u0000';
        System.out.println("====");
        System.out.println(a);
    }

}
