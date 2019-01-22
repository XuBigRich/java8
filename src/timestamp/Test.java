package timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
