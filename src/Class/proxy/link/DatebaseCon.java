package Class.proxy.link;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 模拟数据库连接池 获取数据库连接 并加以代理
 *
 * @Author： hongzhi.xu
 * @Date: 2020/10/27 8:12 下午
 * @Version 1.0
 */
public class DatebaseCon {


    public LinkedList<Connection> list = new LinkedList();

    /**
     * 在加载该类时就创建了一个数据库连接池list,里面10个连接
     * 当多线程请求连接时，遇到 list<=0时，等待，如果客户端返回了连接， 就唤醒等待的连接
     * 目前遇到的问题：程序执行到   notifyAll(); 时出现 java.lang.IllegalMonitorStateException 异常
     * 我很纳闷的是明明是同一个锁啊，为什么？
     * 网上查到：如果当前线程不是对象所得持有者，该方法抛出一个java.lang.IllegalMonitorStateException 异常”
     */
    public synchronized Connection getConnection() throws SQLException {
        while (list.size() <= 0) {
            try {
                System.out.println(" 开始等待。。。。。。 ");
                wait();
            } catch (InterruptedException e) {
                System.out.println(" has waiting error! ");
            }
        }
        final Connection con = list.removeFirst();
        System.out.println(" 实际连接是： " + con);
        Connection conn = (Connection) Proxy.newProxyInstance(DatebaseCon.class.getClassLoader()
                , new Class[]{Connection.class}
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (!method.getName().equals("close")) {
                            return method.invoke(con, args);
                        } else {
                            //当客户端调用 con.close() 方法时，实际是将连接放到list中
                            //此外这个地方一定要注意notifyAll()一定要写在 某个锁块的内部
                            synchronized (DatebaseCon.this) {
                                list.add(con);
                                System.out.println(" 归还了数据库连接 ， 现在池子大小是： " + list.size() + " -- ");
                                notifyAll();
                                return null;
                            }
                        }
                    }
                });
        return conn;
    }
}
