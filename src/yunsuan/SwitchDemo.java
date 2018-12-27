package yunsuan;

public class SwitchDemo {
    public static void test(int a){
        switch (a){
            case 2:
                System.out.println("2");
            case -1:
                System.out.println("-1");
        }
    }
    public static void main(String[] args) {
    		test(10);
    	}
}
