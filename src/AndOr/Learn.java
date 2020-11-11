package AndOr;

/**
 * 学习短路与 与 短路或
 *
 * @Author： hongzhi.xu
 * @Date: 2020/11/7 4:07 下午
 * @Version 1.0
 */
public class Learn {
    public static boolean printTrue() {
        System.out.println("我输出了true");
        return true;
    }

    public static boolean printFalse() {
        System.out.println("我输出了false");
        return false;
    }

    public static void main(String[] args) {

        //遇真则停
        System.out.println("=====遇真则停 返回真=====");
        System.out.println(printFalse() || printTrue());
        System.out.println(printTrue() || printFalse());

        //遇假则停
        System.out.println("=====遇假则停 返回假=====");
        System.out.println(printTrue() && printFalse());
        System.out.println(printFalse() && printTrue());

        //执行到底
        System.out.println("=====执行到底 有一个真的 返真=====");
        System.out.println(printTrue() | printFalse());
        System.out.println(printFalse() | printTrue());
        //执行到底
        System.out.println("=====执行到底 有一个假的 返假=====");
        System.out.println(printTrue() & printFalse());
        System.out.println(printFalse() & printTrue());
    }
}
