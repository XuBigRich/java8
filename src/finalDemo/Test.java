package finalDemo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2019年04月11日 21:17:00
 */
//public class Test extends Final{  //final类不可以被继承
public class Test {

  public static void main(String[] args) {
     final  int[] a={0,1};
     a[0]=2;
     a[1]=3;
     for(int v:a){
         System.out.println(v);
     }
  	}

}
