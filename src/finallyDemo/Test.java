package finallyDemo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2019年04月11日 17:18:00
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().test());
    	}
    public Object test(){
        int x=1;
        String a;
        try {
            a="try中修改";
            System.out.println(a);
          return x;   //return的返回 一定要在 finally 运行完毕之后再返回；再finally运行期间
                    // return 返回值放置在函数栈中
        }finally {
            System.out.println("finally执行了");
            a="final 修改";
            System.out.println(a);
            ++x;
            return a;
        }
    }
}
