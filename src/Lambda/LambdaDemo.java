package Lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
    String[] atp = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka",
            "David Ferrer","Roger Federer",
            "Andy Murray","Tomas Berdych",
            "Juan Martin Del Potro"};
    List<String> players= Arrays.asList(atp);//数组转集合
    // 以前的循环方式
    public void befor(){
        for (String player : players) {
            System.out.print(player + "; ");
        }

    }

    //lambda表达式
    public void lambda(){
        players.forEach((player)->System.out.println(player));
    }
    // 在 Java 8 中使用双冒号操作符(double colon operator)
    public void smh(){
//        players.forEach(System.out::pri  ntln);
    }
    public static void main(String[] args) {
        LambdaDemo lambdaDemo=new LambdaDemo();
        lambdaDemo.befor();
        System.out.println("========================================");
        lambdaDemo.lambda();
        System.out.println("========================================");
        lambdaDemo.smh();
    	}
}
