package sjjg.ZhanAndDuilie;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyStack.java
 * @Description 栈
 * @createTime 2019年02月26日 10:50:00
 */
public class MyStack {
    private long[] arr;
    private int top;
    /*
    * 默认构造方法
    * */
    public MyStack(){
        arr=new long[10];
        top=-1;
    }
    public MyStack(int maxsize){
        arr=new long[maxsize];
        top=-1;
    }
    /*
    * 添加数据
    * */
    public void push(int value){
        arr[++top]=value;
    }
    /*
    * 移除数据
    * */
    public long pop(){
        return arr[top--];  //先赋值再 --
    }
    /*
    * 查看数据
    * */
    public long peek(){
        return arr[top];
    }
    /*
    * 判断是否为空
    * */
    public boolean isEmpcy(){
        return top==-1;
    }
    /*
    * 判断是否满了
    * */
    public boolean isFull(){
        return top==arr.length-1;
    }
}
