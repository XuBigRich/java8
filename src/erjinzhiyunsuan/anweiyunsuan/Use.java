package erjinzhiyunsuan.anweiyunsuan;

/**
 * @Author： hongzhi.xu
 * @Date: 2020/11/18 下午3:35
 * @Version 1.0
 */
public class Use {
    public static void main(String[] args) {
        Object o=new Object();
        int hashcode=o.hashCode();
        System.out.println(hashcode);
        System.out.println(Integer.toBinaryString(hashcode));
        System.out.println(Integer.toBinaryString(hashcode>>>16));
        System.out.println( hashcode^(hashcode>>>16));
        System.out.println( Integer.toBinaryString(hashcode^(hashcode>>>16)));
    }
}
