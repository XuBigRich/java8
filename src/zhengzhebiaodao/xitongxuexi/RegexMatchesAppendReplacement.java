package zhengzhebiaodao.xitongxuexi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Matcher 类也提供了appendReplacement 和 appendTail 方法用于文本替换：*/
public class RegexMatchesAppendReplacement{
   private static String REGEX = "a*b";
   private static String INPUT = "aabfooaabfooabfoobkkk";
   private static String REPLACE = "-";
   public static void main(String[] args) {
      Pattern p = Pattern.compile(REGEX);
      // 获取 matcher 对象
      Matcher m = p.matcher(INPUT);
      StringBuffer sb = new StringBuffer();
      while(m.find()){
         m.appendReplacement(sb,REPLACE);
         System.out.println(sb.toString());
      }
      m.appendTail(sb);
      System.out.println(sb.toString());
   }
}