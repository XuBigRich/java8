package mianshiti.duoxiancheng;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestSync2.java
 * @Description TODO
 * @createTime 2019年04月11日 07:28:00
 */
public class TestSync2 implements Runnable {
    public int b=100;
    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void m1() throws InterruptedException {
        String name= Thread.currentThread().getName();
        System.out.println(name);
            b=1000;
        System.out.println(name);
//            Thread.sleep(500); 注释掉他 容易出现 1000  1000 与 2000 1000 两种情况
            System.out.println("m1 b : "+b);
        System.out.println(name);
    }
    public synchronized void m2(){
       String name= Thread.currentThread().getName();
        System.out.println(name);
        try {
            Thread.sleep(250);
            b=2000;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name);
    }
    public static void main(String[] args) {
        TestSync2 testSync2=new TestSync2();
        Thread thread=new Thread(testSync2);
        thread.start();
        testSync2.m2();
        System.out.println("mian b : "+testSync2.b);

    	}
    	/*
    	* 输出结果为  (且不唯一)
    	*   mian b : 2000
        *   m1 b : 2000
        *   原因是 ： 不管 是thread线程 还是main线程 操作的 都是 testSync2指向的对象
        *   所以 b的值 为多少 不取决于 线程 是谁 而取决于 线程操作的对象 是否是同一个 对象
        *   //========================================
        *    此处 都操作的testSync这个对象 所以 值 会改变  （这个 属于 对象 相同 情况也可能出现在 静态变量中）
        *
        * */
}
