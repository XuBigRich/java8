package hash.hashcode;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * hashcode 是 内存地址
 * 理论上 不同对象 的 内存地址是不一样
 * 但是
 * 也会有 不同对象 hashcode值一样的情况出现
 *
 * 打断点查看对象地址
 */
public class HashCodeDemo {
    /**
     * 相同object的hashcode
     */
    public static void equObject() {
        Object a = new Object();
        Object b = a;
        int aa = a.hashCode();
        int bb = b.hashCode();
        System.out.println(aa + " " + bb);
    }

    /**
     * 展示与验证  字符串
     * 相同字符串，其实是统一对象，所以 hashcode 理应也相同
     * 使用debug 查看 对象地址
     */
    public static void objectEqu() {
        String a = "Aa";
        String b = "Aa";
        int aa = a.hashCode();
        int bb = b.hashCode();
        System.out.println(aa + " " + bb);
    }

    /**
     * 展示 不同对象相同的 hashcode 理应不同
     */
    public static void unEquHashCodeUnEquObject() {
        String a = "aaaa";
        String b = "bbbb";
        int aa = a.hashCode();
        int bb = b.hashCode();
        System.out.println(aa + " " + bb);
    }

    /**
     * 展示 对象不同   hashcode 相同的案例
     *
     */
    public static void equHashCodeUnEquObject() {
        String a = "Aa";
        String b = "BB";
        int aa = a.hashCode();
        int bb = b.hashCode();
        System.out.println(aa + " " + bb);
    }


    public static void main(String[] args) {
        equObject();
        objectEqu();
        unEquHashCodeUnEquObject();
        equHashCodeUnEquObject();
    }
    /*
     * 出现这种状况的原因是：
     *   java中String.hashCode()方法的算法如下:str.charAt(0)*31n-1 +str.charAt(1)*31n-2 +...+str.charAt(n-1)
     *   据说算法中31这个数字是对英文字符进行优化后产生的一个最佳数字,但是碰上字母大小写或是一些特殊字符,再或者是中文字符,它就不灵了,很容易重复,
     * */
}
