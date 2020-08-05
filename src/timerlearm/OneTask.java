package timerlearm;

import java.util.TimerTask;

/**
 * @Author： hongzhi.xu
 * @Date: 2020/8/3 6:23 下午
 * @Version 1.0
 */
public class OneTask extends TimerTask {
    public int id;
    public OneTask(int id){
        this.id=id;
    }
    @Override
    public void run() {
        System.out.println("id="+this.id);
    }
}
