package DateDemo.DurationAndPeriod;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author 许鸿志
 * @since 2022/2/21
 */
public class DurationAndPeriod {
    public static void main(String[] args) {
        LocalDate startTime =LocalDate.of(2022, 2, 22);
        LocalDate middleTime = LocalDate.of(2022, 5, 23);
        LocalDate endTime = LocalDate.of(2023, 6, 22);
        //只统计月份
        System.out.println(Period.between(startTime, endTime).getMonths());
        //会统计总月份 考虑年 不考虑日
        System.out.println(Period.between(startTime, endTime).toTotalMonths());
        //中间差几个月   --不可取 有坑
        System.out.println(ChronoUnit.MONTHS.between(startTime, middleTime));
        //相差几个月
        System.out.println(ChronoUnit.MONTHS.between(startTime, endTime));
        //相差多少天
        System.out.println(ChronoUnit.DAYS.between(startTime, endTime));
        //相差多少天
        System.out.println(Period.between(startTime, endTime).getDays());
        //Duration 需要精确到时间
        System.out.println(Duration.between(LocalDateTime.now(), LocalDateTime.parse("2023-02-18 09:30:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).toDays());
    }

}
