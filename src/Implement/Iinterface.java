package Implement;

public interface Iinterface {
    void a();
    //    void b();
    static void b(){

    }
    default Integer c(int a,int b){
        return new Integer(a)+new Integer(b);
    }
}
