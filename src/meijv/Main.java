package meijv;

import java.util.Map;

public class Main {

    public void xu(Map<String, Object> hong){
//      String a=  hong.get(Meijv.CONTENT).toString();
      String b=(Meij.NOT_EXISTS.getMsg().toString());
//        System.out.println(a);
        System.out.println(b);
    public static void main(String[] args) {
        Main main=new Main();
        main.xu(null);
    }
}
