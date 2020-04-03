package Class.testMethodName;

public class TestDemo extends Thread {
    public int  TestDemo(){
        return 1;
    }
    public void say(){
        System.out.println("我被运行了");
        System.out.println("我被运行了");
    }

    public static void main(String[] args) {
        TestDemo testDemo=new TestDemo();
        testDemo.TestDemo();
        String str1="hello";
        String str2="he"+new String("llo");
        System.err.println(str1==str2);

    }


}
