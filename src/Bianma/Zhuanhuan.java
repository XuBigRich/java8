package Bianma;

public class Zhuanhuan {
//1.十进制转unicode编码
    public static String decToHex(String s){
        String[] ds=s.split(";");
        StringBuffer sbf=new StringBuffer();
        for(int i=0;i<ds.length;i++){
            if(ds[i].startsWith("&#")){
                Integer tem=Integer.parseInt(ds[i].replace("&#", ""));
                sbf.append("\\u").append(Integer.toHexString(tem)+" ");
            }
        }
        return sbf.toString();
    }
    //2.unicode转char数组
    /**
     * unicode 转字符数组
     */
    public static char[] unicode2Chars(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        char[] cs=new char[hex.length];

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);
            cs[i]=(char) data;
        }

        return cs;
    }
    /**
     *
     * @param 汉字
     * @return unicode编码
     */
    public static String toUnicode(String s) {
        String as[] = new String[s.length()];
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            as[i] = Integer.toHexString(s.charAt(i) & 0xffff);
            s1 = s1 + "\\u" + as[i];
        }
        return s1;
    }

    public static void main(String[] args) {
        String hex="\u5df2\u5b9e\u540d\u5236";// 十六进制

        String dec = "&#20840;&#29699;&#36890;";//十进制
        String s="已实名制";//字符串
        System.out.println( Zhuanhuan.decToHex(dec));
    	}
}
