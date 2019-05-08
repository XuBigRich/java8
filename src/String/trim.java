package String;

public class trim {
    public static String kongge="    ass   da      ";
    public static void qckg(){
        //只取去除前后空格，不去除中间空格
        String qckg=kongge.trim();
        System.out.println("空格去除前："+kongge);
        System.out.println("空格去除后："+qckg);
    }
    public static void main(String[] args) {
    		trim.qckg();
    	}
}
