package chouxianglei;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2019年04月11日 18:14:00
 */
public class Test extends Cscxl {

    @Override
    public void say() {

    }
    public void say(String a) {
        System.out.println(a+"我是抽象子类");
    }
    public void say(Integer s){
        super.say(s);  //如果想调用父类方法 可以在 方法中 写 super.方法名()
        System.out.println(s+"我是抽象类中 子类的 方法");
    }
    public static void main(String[] args) {
    		Test test =new Test();
    		test.say("抽象类：");  //子类重写方法后 默认调用 子类方法
            test.say(3);
            test.say(true);  //子类 默认自动继承 父类方法 虽然看不到
    	}
}
