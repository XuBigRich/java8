package Lambda.use;


public class TestLambda {
    public static String convert(String a,Shift shift1){
        return shift1.getValue(a);
    }
    public static String[] upperCase(String string){
        String s=convert(string, (str -> str.toUpperCase()));
        String b=convert(s,str -> str.substring(2,5));
        String sb[]={s,b};
        return sb;
    }
    public static void main(String[] args) {
        String[] w=upperCase("abcdef");
        for(String e:w){
            System.out.println(e);
        }
    	}
}
