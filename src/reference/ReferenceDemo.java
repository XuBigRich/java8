package reference;

import java.lang.ref.*;

/**
 * 强引用、软引用、弱引用、虚引用
 * <p>
 * <p>
 * 除了幻象引用（因为 get 永远返回 null），如果对象还没有被销毁，都可以通过 get 方法获取原有对象。
 * 这意味着，利用软引用和弱引用，可以将访问到的对象，重新指向强引用，也就是人为的改变了对象的可达性状态！这也是为什么上面图里有些地方画了双向箭头。
 *
 * @Author： hongzhi.xu
 * @Date: 2022/7/11 9:16 下午
 * @Version 1.0
 */
public class ReferenceDemo {
    /**
     * 软饮用 当 内存将要满的时候才会 触发GC，然后清除引用对象，否则不会 清除
     */
    public static void softReference() {
        System.out.println("start");
        ReferenceQueue queue = new ReferenceQueue();
        String obj = "test";
        SoftReference<String> sr = new SoftReference<String>(obj, queue);
        obj = null;
        System.out.println(sr.get());
        Reference reference = queue.poll();
        System.out.println(reference.get());
        System.out.println("end");

    }

    /**
     * 弱引用 只会存活至下一次GC发生之前
     * <p>
     * 在使用软引用和弱引用的时候，我们可以显示地通过System.gc()来通知JVM进行垃圾回收，但是要注意的是，虽然发出了通知，JVM不一定会立刻执行，
     * 也就是说这句是无法确保此时JVM一定会进行垃圾回收的。
     * <p>
     * 弱引用还可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引
     * 用队列中。
     *
     * @throws InterruptedException
     */
    public static void weakReference() throws InterruptedException {
        ReferenceQueue queue = new ReferenceQueue();
        WeakReference<String> sr = new WeakReference<String>(new String("hello"), queue);
        System.out.println(sr.get());
//        System.gc();
//        Thread.sleep(2000);
        System.out.println(sr.get());
        Reference reference = queue.poll();
//        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(reference.get());
    }

    /**
     * 特点：虚引用也叫幻象引用，通过PhantomReference类来实现。无法通过虚引用访问对象的任何属性或函数。
     * 幻象引用仅仅是提供了一种确保对象被 finalize 以后，做某些事情的机制。
     * 如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。
     * 虚引用必须和引用队列 （ReferenceQueue）联合使用。当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，
     * 就会在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中。
     */
    public static void phantomReference() {
        //程序可以通过判断引用队列中是否已经加入了虚引用，来了解被引用的对象是否将要被垃圾回收。
        // 如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取一些程序行动。
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference pr = new PhantomReference("aaa", queue);
        System.out.println(pr.get());
        Reference reference = queue.poll();
        System.out.println(reference.get());
    }

    /**
     * 谈到各种引用的编程，就必然要提到引用队列。在创建各种引用并关联到响应对象时，可以选择是否需要关联引用队列，
     * JVM 会在特定时机将引用 enqueue 到队列里，可以从队列里获取引用（remove 方法在这里实际是有获取的意思）进行相关后续逻辑。
     * 尤其是幻象引用，get 方法只返回 null，如果再不指定引用队列，基本就没有意义了。看看下面的示例代码。
     * 利用引用队列，可以在对象处于相应状态时（对于幻象引用，就是前面说的被 finalize 了，处于幻象可达状态），执行后期处理逻辑。
     */
    public static void referenceQueue() {
        Object counter = new Object();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        PhantomReference<Object> p = new PhantomReference<>(counter, refQueue);
        counter = null;
        System.gc();
        try {
            // Remove 是一个阻塞方法，可以指定 timeout，或者选择一直阻塞
            Reference<Object> ref = refQueue.remove(1000L);
            if (ref != null) {
                System.out.println(ref.get());

                System.out.println(p.get());
                // do something
            }
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
//        softReference();
//        weakReference();
//        phantomReference();
        referenceQueue();
    }

}
