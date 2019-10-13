package zhengzhebiaodao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) throws Exception {
        String str = "10.2368686986859686"; 
        Pattern p = Pattern.compile("[\\d]*[\\.][\\d]{2}"); // 小数保留两位小数
        Matcher m = p.matcher(str);
        // 查找相应的字符串
        while (m.find()) {
            String tmp = m.group();
            if (!"".equals(tmp)) {
                 System.out.println(tmp);
            }
        }
        // 判断是否匹配
        System.out.println(m.matches());
        str = "上山打老虎打不到";
        p = Pattern.compile("老虎打不到");
        m = p.matcher(str);
        // 查找相应的字符串
        while (m.find()) {
            String tmp = m.group();
            if (!"".equals(tmp)) {
            System.out.println(tmp);
            }
        }
    }
}