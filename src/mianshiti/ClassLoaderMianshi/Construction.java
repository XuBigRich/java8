package mianshiti.ClassLoaderMianshi;

/**
 * 问题描述：
 *  无参构造函数调用有参构造函数，使用非静态default变量调用 报错Cannot reference 'Construction.default_' before supertype constructor has been called
 *  但是如果调用静态的default变量则会编译通过。
 *
 *  百度问题原因：
 *      代码最初无法编译的原因是，defaultValue是类Construction的一个实例变量，
 *      这意味着当创建一个Construction类型的对象时，还会创建一个惟一的defaultValue实例并将其附加到该特定对象。
 *      因此，不能在构造函数中引用defaultValue，因为它和对象都还没有创建。
 *      所以只能知道他被初始化到了值，但他的载体对象还未生成于是就不能使用这个变量干任何事。
 *
 *      而后来使用静态变量后 编译通过，是因为我们以前说过static的属性方法等 属于三界之外的独立 属性。
 *      不依赖于对象而存在所以我们可以用它来生成对象
 *
 *
 * 解决方案是使最后的变量静态:
 */
public class Construction {
        private static int defaultValue=10;
//    private int defaultValue = 10;
    private int port;

    public Construction(int port) {
        this.port = port;
    }

    public Construction() {
        //调用已有的构造方法 发现构造失败
        this(defaultValue);
    }
}
