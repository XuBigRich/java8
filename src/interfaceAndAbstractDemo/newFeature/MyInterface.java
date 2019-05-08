package interfaceAndAbstractDemo.newFeature;
@FunctionalInterface//检查此接口是否为函数式接口
public interface MyInterface<T> {//此处T是声明 这个接口可以加泛型
    void a(T t);
    //    void b();
    static void b(){

    }
    default Integer c(int a,int b){
        return new Integer(a)+new Integer(b);
    }
}
