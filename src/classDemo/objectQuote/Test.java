package classDemo.objectQuote;

/**
 * Java 值传递的另一种 验证
 * @author 许鸿志
 * @since 2022/9/5
 */
public class Test {

    private Target target;
    private String name;

    public void pre(Target target) {
        this.target = target;
    }

    public void init() {
        this.name = target.getName();
    }

    public void print() {
        System.out.println(name);
    }


    public static void main(String[] args) {
        Test test = new Test();
        test.pre(new Target("许鸿志"));
        test.init();
        test.pre(new Target("许大富"));
        // 如果不再次执行init 那么   this.name 的值 并不会随着 target的改变而改变。
        //因为Java是值传递  值传递  值传递
        test.init();
        test.print();


    }
}
