package DateDemo.DurationAndPeriod;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author 许鸿志
 * @since 2022/2/21
 */
public class DurationAndPeriod {
    public static void main(String[] args) {
        LocalDate startTime = LocalDate.now();
        LocalDate endTime = LocalDate.of(2023, 2, 22);
        //只统计月份
        System.out.println(Period.between(startTime, endTime).getMonths());
        //会统计总月份
        System.out.println(Period.between(startTime, endTime).toTotalMonths());

        //Duration 需要精确到时间
        System.out.println(Duration.between(LocalDateTime.now(), LocalDateTime.parse("2023-02-18 09:30:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).toDays());
    }

}
