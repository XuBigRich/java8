package String;

public class StartsWith {
    public String a="abcde";
    public String b="abde ";
    public String[] c={a,b};
    public void panduan(){
        for (String dg:c){
            if(dg.startsWith("ab")){
                System.out.println("��ab��ͷ�Ķ���"+dg);
            }else {
                System.out.println("����ab��ͷ�Ķ���"+dg);
            }
            if(dg.startsWith("abc")){
                System.out.println("��abc��ͷ�Ķ���"+dg);
            }else {
                System.out.println("����abc��ͷ�Ķ���"+dg);
            }
            System.out.println("=============================");
        }
    }
    public static void main(String[] args) {
        StartsWith startsWith=new StartsWith();
        startsWith.panduan();
    	}
}
