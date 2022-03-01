package Class;

/**+
 * 代码执行是先执行静态代码 ，在执行对象代码
 *
 * 若都为静态代码 那么谁在前面 先执行谁。
 *
 * @author 许鸿志
 * @since 2022/3/1
 */
public class ClassExecuteOrder {

    static {
        System.out.println("我是静态块！ 你可以移动我的位置执行看看相应效果！");
    }

    private static ClassExecuteOrder classExecuteOrder1 = new ClassExecuteOrder();


    private static ClassExecuteOrder classExecuteOrder2 = new ClassExecuteOrder();

    {
        System.out.println("我是块！");
    }


    public static void main(String[] args) {
        ClassExecuteOrder classExecuteOrder = new ClassExecuteOrder();
    }
}
