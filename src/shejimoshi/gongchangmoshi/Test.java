package shejimoshi.gongchangmoshi;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2019年04月11日 20:30:00
 */
public class Test {
    public void gc(String name,Person person){
        person.say(name);
    }
    public static void main(String[] args) {
        Test test=new Test();
        test.gc("许鸿志",new Teacher());
    	}
}
