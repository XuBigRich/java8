package String;

public class StartsWith {
    public String a="abcde";
    public String b="abde ";
    public String[] c={a,b};
    public void panduan(){
        for (String dg:c){
            if(dg.startsWith("ab")){
                System.out.println("以ab开头的对象："+dg);
            }else {
                System.out.println("不以ab开头的对象："+dg);
            }
            if(dg.startsWith("abc")){
                System.out.println("以abc开头的对象："+dg);
            }else {
                System.out.println("不以abc开头的对象："+dg);
            }
            System.out.println("=============================");
        }
    }
    public static void main(String[] args) {
        StartsWith startsWith=new StartsWith();
        startsWith.panduan();
    	}
}
