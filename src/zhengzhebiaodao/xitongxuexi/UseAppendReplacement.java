package zhengzhebiaodao.xitongxuexi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseAppendReplacement {
    public static final String condition="[dy\"\\[\\]]";
    public static final String target="\"[d1_y1]\"";

    public static void main(String[] args) {
       Pattern pattern= Pattern.compile(condition );
       Matcher matcher=pattern.matcher(target);
       StringBuffer stringBuffer=new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(stringBuffer,"");
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer);
    }
}