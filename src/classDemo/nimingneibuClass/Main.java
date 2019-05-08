package classDemo.nimingneibuClass;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2019年04月02日 21:24:00
 */
//若要可以使用lamdba类必须是静态的
public class Main {
    public static void main(String[] args) {
    		test test=new test() {
                @Override
                public void sayok() {
                    System.out.println("ok!");
                }
            };

    }
}
