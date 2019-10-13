package DateDemo.getDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

public class DateDemo {
	public static void main(String[] args) {
		//直接new 一个date 输出的 是没法直接用的 有点小乱
		System.err.println(new Date().toString());
		//获取当前时间的时间戳
		System.out.println(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String dqsjString=simpleDateFormat.format(new Date());
		//按照你想要的格式 转换 一个 日期 字符串
		System.out.println(dqsjString);
		
	}
}
