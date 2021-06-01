package runtimeException;

public class Student implements Person {

    private final static int nextId = 1;
    private int id;
    @Override
    public void buyMac(double money){
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        System.out.println("学生买了mac");
        System.out.println("学生花了"+money);
    }

    @Override
    public void takeSubWay(double money){
        System.out.println("学生花"+money+"坐车回家");
    }

    @Override
    public void atHome(){
        System.out.println("到家");
    }

    public void setId(){
        id = nextId;
        //nextId++;
    }

    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void main(String[] args) throws Exception{
        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        Student student = new Student();
        student.buyMac(123123);
    }


}

