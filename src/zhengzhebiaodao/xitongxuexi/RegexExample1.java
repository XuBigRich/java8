package zhengzhebiaodao.xitongxuexi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 正则判断
 * @author ADMIN
 *
 */
public class RegexExample1 {

	public static void main(String[] args) {
		// TODO 判断该字符串再正则表达式中是否合法
		String content="I am noob from runoob.com";
		 String pattern = ".*runoob.*";
		 boolean isMatch = Pattern.matches(pattern, content);
	     System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
	}

}
