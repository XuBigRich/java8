package error;

/**
 * @author 许鸿志
 * @since 2022/8/5
 */
public class NoClassDefFoundErrorDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(20000);
        //DOTO 未完成
        Target target = new Target();
        target.say();
    }
}
