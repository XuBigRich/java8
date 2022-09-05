package classDemo.objectQuote;

/**
 * Java 值传递的另一种 验证
 *
 * @author 许鸿志
 * @since 2022/9/5
 */
public class Test {

    private Target target;
    private String name;

    public void pre(Target target) {
        this.target = target;
    }

    //变相证明这个地方只是吧target的 name 值赋给 name，而不是引用赋给name
    public void init() throws InterruptedException {
        this.name = target.getName();
        Thread.sleep(5000);
    }

    public void print() {
        System.out.println(Thread .currentThread().getName()+" "+name);
    }

    /**
     * 单线陈
     */
    public static void signe() throws InterruptedException {
        Test test = new Test();
        test.pre(new Target("许鸿志"));
        test.init();
        test.pre(new Target("许大富"));
        // 如果不再次执行init 那么   this.name 的值 并不会随着 target的改变而改变。
        //因为Java是值传递  值传递  值传递
        test.init();
        test.print();
    }


    public static void main(String[] args) {
//        signe();

        Test test = new Test();
        Thread t = new Thread(() -> {
            test.pre(new Target("许鸿志"));
            try {
                test.init();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test.print();
        },"1");

//即使上面的init 方法 没走完 也可以 读到 被初始化的方法
        Thread t1 = new Thread(() -> {
            test.pre(new Target("许大富"));
            test.print();
        },"2");

        t.start();
        t1.start();
    }
}
