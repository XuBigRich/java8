package DateDemo.timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 	时间戳 与  日期格式
 * @author ADMIN
 *
 */
/*
 * 步骤：
 * 想要获取一个 字符串  类型的  时间戳  要分三步（仅限于本示例）
 * 第一步： 将字符串  转换为 Date类型
 * 第二步:    通过Date类型的getTime()方法 获取时间戳  时间戳类型为Long
 * 第三部： 将Long类型 转换为String类型 然后输出
 */
public class Test {
    String begin="2018-09-25 00:00:00";
    String finish="2018年09月25日 23时59分59秒";
    String start;
    String end;
    public void parse() throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//约定格式说明；
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date starttime=simpleDateFormat.parse(begin); //将字符串 以约定的格式 转换为  Date(日期类型)
        Date endtime=simpleDateFormat1.parse(finish);
        System.out.println("starttime:"+starttime);
        long start1=starttime.getTime();    //将日期转换为时间戳
        long end1=endtime.getTime();
        start=String.valueOf(start1);//将时间格式转换为字符串
        end=String.valueOf(end1);
        System.out.println(start);
        System.out.println(end);
        String timestamp = (new Date().getTime())+"";
        System.out.println(timestamp);
    }
  public static void main(String[] args) throws ParseException {
  		Test test=new Test();
  		test.parse();
  	}
}
