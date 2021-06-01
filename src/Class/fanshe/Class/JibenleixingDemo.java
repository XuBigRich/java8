package Class.fanshe.Class;

public class JibenleixingDemo {
    /*
     * 证明类中所有组建 都是可以 以对象方式呈现的
     * */
    public static void main(String[] args) {
        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = void.class;
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());//不含包名的类名称
    }

}
