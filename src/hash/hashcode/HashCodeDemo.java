package hash.hashcode;

public class HashCodeDemo {
/*
* hashcode 是 内存地址
* 理论上 不同对象 的 内存地址是不一样
*   但是
*       也会有 不同对象 hashcode值一样的情况出现
* */
    public static void  main (String[] args){
        String a="Aa";
        String b="BB";
        int aa=a.hashCode();
        int bb=b.hashCode();
        System.out.println(aa+" "+bb );
    }
    /*
    * 出现这种状况的原因是：
    *   java中String.hashCode()方法的算法如下:str.charAt(0)*31n-1 +str.charAt(1)*31n-2 +...+str.charAt(n-1)
    *   据说算法中31这个数字是对英文字符进行优化后产生的一个最佳数字,但是碰上字母大小写或是一些特殊字符,再或者是中文字符,它就不灵了,很容易重复,
    * */
}
