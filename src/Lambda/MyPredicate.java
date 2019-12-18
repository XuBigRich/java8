package Lambda;
@FunctionalInterface//检查此接口是否为函数式接口
public interface MyPredicate {
    void a();
    //    void b();
    static void b(){

    }
    default Integer c(int a,int b){
        return new Integer(a)+new Integer(b);
    }
}
