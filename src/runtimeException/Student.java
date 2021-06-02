package runtimeException;

/**
 * StackTraceElement 追踪方法入栈情况
 */
public class Student implements Person {

    @Override
    public void buyMac(double money) {
        System.out.println("学生花了" + money);
        stack();
        atMac();
    }

    public void atMac() {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        System.out.println("学生买了mac");
        stack();
        takeSubWay(2);
    }

    @Override
    public void takeSubWay(double money) {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        System.out.println("学生花" + money + "坐车回家");
        stack();
        atHome();
    }

    @Override
    public void atHome() {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        System.out.println("到家");
        stack();
    }

    public void stack() {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        Student student = new Student();
        student.buyMac(15000);
    }


}

