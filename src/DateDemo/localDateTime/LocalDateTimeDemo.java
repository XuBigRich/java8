package DateDemo.localDateTime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 此为java8 时间新特性
 * 
 * @author hongzhi.xu
 * @version 创建时间：2019年10月23日 上午11:10:36
 */
public class LocalDateTimeDemo {
public static void main(String[] args) {
	String time1 = "2019-11-26 19:00:00";
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.parse(time1, dtf2);
    
	 LocalDateTime now = LocalDateTime.now();
	 Duration duration = Duration.between(now,localDateTime);
        System.out.println(duration);
        long days = duration.toDays(); //相差的天数
        long hours = duration.toHours();//相差的小时数
        long minutes = duration.toMinutes();//相差的分钟数
        long millis = duration.toMillis();//相差毫秒数
        long nanos = duration.toNanos();//相差的纳秒数
        System.out.println(millis);
}
}
