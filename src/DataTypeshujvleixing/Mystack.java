package DataTypeshujvleixing;

public class Mystack {
    private long tack[];
    private int top;
    public Mystack(){
        tack= new long[4];
        top=-1;
    }
    public Mystack(int a){
        tack=new long[a];
        top=-1;
    }

    /*
    *
    * 入栈
    * */
    public void push(long values){
        tack[++top]=values;
    }
    /*
    *
    * 出栈
    * */
    public void pop(int i){
        int g =0;
       while (top-g!=top-i){
           g++;
           System.out.println(tack[top--]);
       }
    }
}
