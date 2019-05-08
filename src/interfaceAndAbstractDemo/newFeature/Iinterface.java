package interfaceAndAbstractDemo.newFeature;

public interface Iinterface {
    void a();
//        void b();
    static void b(){
        System.out.println("a");
    }

    default Integer c(int a,int b){
        return new Integer(a)+new Integer(b);
    }
    default void test(){
        System.out.println(111);
    }
    public static void test1(){
        System.out.println(1);
    }
    default public  void test2(){
        System.out.println(222);
    }
}
