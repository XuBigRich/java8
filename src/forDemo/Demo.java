package forDemo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Demo.java
 * @Description TODO
 * @createTime 2019年02月22日 11:19:00
 */
public class Demo {
    static int element=5;
   public static void text(){
       for(int i=0;i<element;i++){
           System.out.print(i+" ");
       }
   }
    public static void text1(){
        for(int i=0;i<element;++i){
            System.out.print(i+" ");
        }
    }
    public static void text2(){
        for(int i=0;i<=element;i++){
            System.out.print(i+" ");
        }
    }
   public static void main(String[] args) {
   		Demo.text();
       System.out.println("=============================");
   		Demo.text1();
       System.out.println("=============================");
       Demo.text2();
   	}

}
