package hashcode;

/**
 * 重写hashcode 的原理
 * 重写hashcode 判断两个对象是否相等 （用于set排重）
 * 可以将基础类型的hashcode进行打印
 * @author 许鸿志
 * @since 2021/5/22
 */
public class LearHashCode {
    public void a(){
        Integer integer=100;
        String a="123321";
        System.out.println();
        System.out.println(integer.hashCode());
        System.out.println(a.hashCode());
    }
    public void b(){
        Integer integer=100;
        String b="123321";
        System.out.println(integer.hashCode());
        System.out.println(b.hashCode());
    }

    public static void main(String[] args) {
        LearHashCode learHashCode=new LearHashCode();
        learHashCode.a();
        learHashCode.b();
    }
}
