package error;


/**
 * 可以发现
 * 1）ClassNotFoundException为非RuntimeException(CheckedException)，也就是说该异常在程序编译前就会检查出该错误，导致无法通过编译，逼迫程序员修改代码。所以这里的ClassNotFoundException应该指的是找不到所定义的Class的代码段。
 * 2）NoClassDefError并不是发生在编译前，而是编译后的运行期间(通常在jvm类加载过程)，通常分以下三种成因：
 * ①加载该类时发现找不到该类的.class文件或者该类的jar包不存在；
 * ②类的.class文件存在，但是在不同的域中。比如说，.class在当前的java path下不可用又或者说有多个不同的类加载器重复对该类的.class文件进行了加载，就有可能出现这样的问题；
 * ③大小写问题，因为在编译时，虽然类名可能大小写不同，但如果字母都一样，那么最后不管类名大小写是否相同，编译后都只产生一个.class文件！这样就会导致最后编译出来的文件不是我们想要的。
 *
 * @author 许鸿志
 * @since 2022/8/5
 */
public class NoClassDefFoundErrorDemo {
    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(20000);
        //可以看一下 error 包中 只生成了Target 没有生成target 所以，这段代码 先是骗过了编译器，但是执行的时候 会找不到
//        target target = new target();
//        target.say();
    }
}
