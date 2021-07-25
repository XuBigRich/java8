package classLoad.ContextClassLoader;

import classLoad.hostClassLoader.MyFileClassLoader;

/**
 * 学习线程与上下文加载器加载器
 * <p>
 * 首先上下文加载器与线程的关系
 *
 * @Author： hongzhi.xu
 * @Date: 2021/7/4 下午8:57
 * @Version 1.0
 */
public class LearContextClassLoader {
    static {
        Thread.currentThread().setContextClassLoader(new MyFileClassLoader("d:/demo"));
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new ContextThread());
        thread.start();
    }

    public static class ContextThread implements Runnable {

        @Override
        public void run() {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader);
        }
    }
}
