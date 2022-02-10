package Lambda.use;


public class TestLambda {
    /**
     * 需要传入一个String 对象 与 Shift对象
     * @param a
     * @param shift1
     * @return
     */
    public static String convert(String a, Shift shift1) {
        return shift1.getValue(a);
    }

    public static String[] upperCase(String string) {
        String s = convert(string, (str -> str.toUpperCase()));  //Lambda的使用方法是  参数-> 加方法体 (方法体自动套入 方法中)
        String b = convert(s, str -> str.substring(2, 5));
        String sb[] = {s, b};
        return sb;
    }

    public static void main(String[] args) {
        String[] w = upperCase("abcdef");
        for (String e : w) {
            System.out.println(e);
        }
    }
}
