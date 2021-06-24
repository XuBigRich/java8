package zhengzhebiaodao.xitongxuexi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 许鸿志
 * @since 2021/6/22
 */
public class Shuangyinhao {
    public static void test(){
        String options="[\"[<span class=\\\"MathJye\\\" mathtag=\\\"math\\\" style=\\\"whiteSpace:nowrap;wordSpacing:normal;wordWrap:normal\\\"><table cellpadding=\\\"-1\\\" cellspacing=\\\"-1\\\" style=\\\"margin-right:1px\\\"><tr><td style=\\\"border-bottom:1px solid black\\\">1</td></tr><tr><td>8</td></tr></table></span>，2）\",\"[<span class=\\\"MathJye\\\" mathtag=\\\"math\\\" style=\\\"whiteSpace:nowrap;wordSpacing:normal;wordWrap:normal\\\"><table cellpadding=\\\"-1\\\" cellspacing=\\\"-1\\\" style=\\\"margin-right:1px\\\"><tr><td style=\\\"border-bottom:1px solid black\\\">1</td></tr><tr><td>8</td></tr></table></span>，2]\",\"（-∞，<span class=\\\"MathJye\\\" mathtag=\\\"math\\\" style=\\\"whiteSpace:nowrap;wordSpacing:normal;wordWrap:normal\\\"><table cellpadding=\\\"-1\\\" cellspacing=\\\"-1\\\" style=\\\"margin-right:1px\\\"><tr><td style=\\\"border-bottom:1px solid black\\\">1</td></tr><tr><td>8</td></tr></table></span>]\",\"[2，+∞）\"]";
//        System.out.println("\\\\\"");
        String a= options.replaceAll("\\\\\\\"","&amp;");
//        System.out.println(a);
        String pattStr = "(?<=\").*?(?=\")";
        Pattern pattern= Pattern.compile(pattStr);
        Matcher matcher=pattern.matcher(a);
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        test();
    }
}
