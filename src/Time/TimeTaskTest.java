package Time;

import java.util.Timer;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TimeTask.java
 * @Description TODO
 * @createTime 2019年04月15日 16:19:00
 */
public class TimeTaskTest{

    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new Task1(),100);
        timer.schedule(new Task2(),1);
    }
}
