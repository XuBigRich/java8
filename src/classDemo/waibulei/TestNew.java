package classDemo.waibulei;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestNew.java
 * @Description TODO
 * @createTime 2019年04月17日 17:30:00
 */
public class TestNew {
    W2 w2=new W2();  // 说明外部类调用  无需 初始化 其所在 类 位置 , 区别于 内部类 需要 先初始化 外部类

    public static void main(String[] args) {
        new TestNew();
    }
}
