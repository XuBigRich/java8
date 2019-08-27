package zhengzhebiaodao.xitongxuexi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDemo {
   private static String REGEX = "dog";
   private static String INPUT = "The dog says meow " + "All dogs say meow.";
   private static String REPLACE = "cat$";

   public static void main(String[] args) {
      Pattern pattern = Pattern.compile(REGEX);

      // get a matcher object
      Matcher matcher = pattern.matcher(INPUT);

      try {
         //Below line will throw exception
         INPUT = matcher.replaceAll(REPLACE);
      } catch (Exception e) {
         System.out.println("Exception: " + e.getMessage());
      }
      INPUT = matcher.replaceAll(matcher.quoteReplacement(REPLACE));
      System.out.println(INPUT);
   }
}

