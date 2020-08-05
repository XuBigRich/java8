package timerlearm;

import java.util.Date;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 对Timer的学习
 * @Author： hongzhi.xu
 * @Date: 2020/8/3 6:22 下午
 * @Version 1.0
 */
public class TimerUse {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        timer.schedule(new OneTask(1), 5000);// 5秒后启动任务

        OneTask secondTask = new OneTask(2);
        timer.schedule(secondTask, 1000, 3000);// 1秒后启动任务,以后每隔3秒执行一次线程

        Date date = new Date();
        timer.schedule(new OneTask(3), new Date(date.getTime() + 1000));//以date为参数，指定某个时间点执行线程

//      timer.cancel();
//      secondTask.cancel();
        System.out.println("end in main thread...");
        Thread.sleep(5000);
        //终止所有定时任务
        timer.cancel();
//        ScheduledExecutorService scheduledExecutorService=new ScheduledThreadPoolExecutor(20);
//        scheduledExecutorService.schedule(new OneTask(1), 5, TimeUnit.SECONDS);
    }
}
