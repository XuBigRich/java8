package zhengzhebiaodao.xitongxuexi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author ADMIN
 *捕获组
 */
public class CGORE {
	public static void main(String[] args) {
		  // TODO 捕获组
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        //正则表达式的捕获组
		/* 对这个捕获组的自然语言翻译      （前面不能有数字）（必须有一个数字或多个数字）（后面随便写）*/
        String cgore = "(\\D*)(\\d+)(.*)";
   
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(cgore);
   
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
           System.out.println("Found value: " + m.group(0) );
           System.out.println("Found value: " + m.group(1) );
           System.out.println("Found value: " + m.group(2) );
           System.out.println("Found value: " + m.group(3) ); 
        } else {
           System.out.println("NO MATCH");
        }
	}
}
