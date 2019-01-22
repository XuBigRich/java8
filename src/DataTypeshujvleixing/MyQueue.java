package DataTypeshujvleixing;

public class MyQueue {

    /*
     *建立队列
     * */
    public long[] queue;
    public int top,end;
    public long lang;
    public MyQueue(){
        queue= new long[5];
        top=0;
        lang=0;
        end=0;
    }
    /*
    * 加入队列
    * */
    public void insert(long i){
        lang++;
        queue[end]=i;
    }
    /*
    * 删除队列
    * */
    public void delete (){

    }
}