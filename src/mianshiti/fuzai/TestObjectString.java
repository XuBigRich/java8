package mianshiti.fuzai;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestObjectString.java
 * @Description TODO
 * @createTime 2019年04月11日 09:50:00
 */
/*
* 会输出 string  因为 重载的方法是 不精准的
* */
public class TestObjectString {
    public void myMethod(String str){
        System.out.println("string");
    }
    public void myMethod(Object obj){
        System.out.println("object");
    }
    public static void main(String[] args) {
    		TestObjectString testObjectString=new TestObjectString();
    		testObjectString.myMethod(null);
    	}
}
