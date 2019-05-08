package sjjg.ZhanAndDuilie;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyQueue.java
 * @Description TODO
 * @createTime 2019年02月26日 11:32:00
 */
public class MyQueue {
    //底层使用数组
    private long[] arr;
    //有效数据大小
    private int elements;
    //队头
    private int front;
    //队尾
    private int end;
    /*
    * 默认构造方法
    * */
    public MyQueue(){
        arr=new long[10];
        front=0;
        end=-1;
        elements=0;
    }
    public MyQueue(int maxsize){
        arr=new long[maxsize];
        front=0;
        end=-1;
        elements=0;
    }
    /*
    * 添加数据，从队尾添加  (构造循环 数组)
    * */
    public void insert(long value){
        if(end==arr.length-1){
            end=-1;
        }
        arr[++end]=value;
        elements++;
    }
    /*
    * 删除数据,从对头删除
    * */
    public long remove(){
        elements--;
        if(front==arr.length){  //这个地方 之所以 为front==arr.length 是因为X
            front=0;
        }
       return arr[front++];
    }
    /*
    * 查看数据,从队头查看
    * */
    public long peek(){
        return arr[front];
    }
    /*
    * 判断是否为空
    * */
    public boolean isEmpty(){
        return elements==0;
    }
    public boolean isPull(){
        return elements==arr.length;
    }
}
