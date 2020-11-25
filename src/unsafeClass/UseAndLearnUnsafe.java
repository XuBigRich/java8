package unsafeClass;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用并学习Unsafe类
 * <p>
 * Java和C++语言的一个重要区别就是Java中我们无法直接操作一块内存区域，不能像C++中那样可以自己申请内存和释放内存。
 * Java中的Unsafe类为我们提供了类似C++手动管理内存的能力。
 * Unsafe类，全限定名是sun.misc.Unsafe，从名字中我们可以看出来这个类对普通程序员来说是“危险”的，一般应用开发者不会用到这个类。
 * <p>
 * Unsafe类是"final"的，不允许继承。且构造函数是private的: 因此我们无法在外部对Unsafe进行实例化。
 * <p>
 * <p>
 * *  *  *  *  *  *  *  *  * 获取Unsafe *  *  *  *  *  *  *
 * Unsafe无法实例化，那么怎么获取Unsafe呢？答案就是通过反射来获取Unsafe：
 * <p>
 * *  *  *  *  *  *  *  *  * 直接读写 *  *  *  *  *  *  *  *  *  *
 * <p>
 * 普通的读写
 * <p>
 * Unsafe这个类还可直接在一个地址上读写 请看getSpecifiedMemory 与 setSpecifiedMemory 方法
 * <p>
 * volatile读写
 * 普通的读写无法保证可见性和有序性，而volatile读写就可以保证可见性和有序性。
 * getIntVolatile方法用于在对象指定偏移地址处volatile读取一个int。putIntVolatile方法用于在对象指定偏移地址处volatile写入一个int。
 * <p>
 * volatile读写相对普通读写是更加昂贵的，因为需要保证可见性和有序性，而与volatile写入相比putOrderedXX写入代价相对较低，putOrderedXX写入不保证可见性，但是保证有序性，所谓有序性，就是保证指令不会重排序。
 * <p>
 * *  *  *  *  *  *  *  *  * 根据某属性相对于其对象的相对位置 进行属性的 读写 *  *  *  *  *  *  *  *  *  *
 * 请看getFile方法
 * * *  *  *  *  *  *  *  *  * 获取偏移量相关 *  *  *  *  *  *  *  *  *  *
 * getOffset方法
 * * *  *  *  *  *  *  *  *  * CAS相关 *  *  *  *  *  *  *  *  *  *
 * useCAS方法
 * * * *  *  *  *  *  *  *  *  * 线程调度 *  *  *  *  *  *  *  *  *  *
 * park方法和unpark方法相信看过LockSupport类的都不会陌生，这两个方法主要用来挂起和唤醒线程。
 * LockSupport中的park和unpark方法正是通过Unsafe来实现的：
 * monitorEnter方法和monitorExit方法用于加锁，Java中的synchronized锁就是通过这两个指令来实现的。
 *
 * * * *  *  *  *  *  *  *  *  * 类加载 *  *  *  *  *  *  *  *  *  *
 * classLoader方法
 *
 * @Author： hongzhi.xu
 * @Date: 2020/10/30 2:42 下午
 * @Version 1.0
 */
public class UseAndLearnUnsafe {
    public int target;


    private Unsafe theUnsafe;
    private UseAndLearnUnsafe useAndLearnUnsafe;


    /**
     * 给theUnsafe 与 useAndLearnUnsafe 赋值
     *
     * @return
     * @throws IllegalAccessException
     */
    public UseAndLearnUnsafe() throws IllegalAccessException {
        this.useAndLearnUnsafe = this;
        /**
         * 生成Unsafe对象的关键
         * 其原理是，通过反射的方式获取Unsafe对象，因为 Unsafe会在类被装载时，生成一个静态的Unsafe对象
         * 然后直接通过Field的get方法直接给他把属性对象给他捞出来。
         * 年轻人不讲武德，别人生成好的私有对象 ，他通过反射的方式给他 劫糊了！
         * 就此 Unsafe获得了一个私有变量
         */

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        this.theUnsafe = unsafe;
    }

    /**
     * 给useAndLearnUnsafe对象的target属性设置值
     * 通过获取到target属性在这个对象中的偏移量    **注意 是 相对于这个useAndLearnUnsafe对象的偏移量 不是内存起始位偏移量
     * 然后通过theUnsafe直接操作内存 赋值给 target 属性
     */
    public void getFile() {
        try {
            Field field = useAndLearnUnsafe.getClass().getField("target");
            long l = theUnsafe.objectFieldOffset(field);
            System.out.println(l);
            theUnsafe.putOrderedInt(useAndLearnUnsafe, l, 22);
            System.out.println(useAndLearnUnsafe.target);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取地址上是一个int类型的值
     *
     * @param address 传入的地址
     */
    public void getSpecifiedMemory(long address) {
        int b = theUnsafe.getInt(address);
        System.out.println(b);
    }


    /**
     * 给某一个地址赋值
     *
     * @param address 传入的地址
     */
    public void setSpecifiedMemory(long address) {
        theUnsafe.putInt(address, 20);
    }

    /**
     * 其他对内存操作的方法
     */
    public void otherOperation() {
        // 分配内存
        //theUnsafe.allocateMemory();
        // 重新分配内存
        // theUnsafe.reallocateMemory();
        // 内存初始化
        //  theUnsafe.setMemory();
        // 内存复制
        //  theUnsafe.copyMemory();
        // 清除内存
        //  theUnsafe.freeMemory( );
    }

    /**
     * 获取偏移量的方法
     */
    public void getOffset() {
//       staticFieldOffset方法用于获取静态属性Field在对象中的偏移量，读写静态属性时必须获取其偏移量
//    public native long staticFieldOffset(Field var1);
//          objectFieldOffset方法用于获取非静态属性Field在对象实例中的偏移量，读写对象的非静态属性时会用到这个偏移量
//    public native long objectFieldOffset(Field var1);
//          staticFieldBase方法用于返回Field所在的对象。
//    public native Object staticFieldBase(Field var1);
//          arrayBaseOffset方法用于返回数组中第一个元素实际地址相对整个数组对象的地址的偏移量。
//    public native int arrayBaseOffset(Class<?> var1);
//          arrayIndexScale方法用于计算数组中第一个元素所占用的内存空间。
//    public native int arrayIndexScale(Class<?> var1);
    }

    /**
     * JUC中大量运用了CAS操作，可以说CAS操作是JUC的基础，因此CAS操作是非常重要的。
     * Unsafe中提供了int,long和Object的CAS操作
     */
    public void useCAS() {
        //某个对象，相对于某个对象 其某个属性的偏移量，期望值，改成什么值
//        public final native boolean compareAndSwapObject(Object var1, long var2, Object var4, Object var5);
//
//        public final native boolean compareAndSwapInt(Object var1, long var2, int var4, int var5);
//
//        public final native boolean compareAndSwapLong(Object var1, long var2, long var4, long var6);
    }

    public void classLoader() {
        //defineClass方法定义一个类，用于动态地创建类。
//        public native Class<?> defineClass(String var1, byte[] var2, int var3, int var4, ClassLoader var5, ProtectionDomain var6);
        //defineAnonymousClass用于动态的创建一个匿名内部类。
//        public native Class<?> defineAnonymousClass(Class<?> var1, byte[] var2, Object[] var3);
        //allocateInstance方法用于创建一个类的实例，但是不会调用这个实例的构造方法，如果这个类还未被初始化，则初始化这个类。
//        public native Object allocateInstance(Class<?> var1) throws InstantiationException;
        //shouldBeInitialized方法用于判断是否需要初始化一个类。
//        public native boolean shouldBeInitialized(Class<?> var1);
        //ensureClassInitialized方法用于保证已经初始化过一个类。
//        public native void ensureClassInitialized(Class<?> var1);
    }

    public void barrir() {
        //loadFence：保证在这个屏障之前的所有读操作都已经完成。
//    public native void loadFence();
//storeFence：保证在这个屏障之前的所有写操作都已经完成。
//    public native void storeFence();
//fullFence：保证在这个屏障之前的所有读写操作都已经完成
//    public native void fullFence();
    }

    public static void main(String[] args) throws IllegalAccessException {
        UseAndLearnUnsafe useAndLearnUnsafe = new UseAndLearnUnsafe();
        useAndLearnUnsafe.getFile();
    }
}