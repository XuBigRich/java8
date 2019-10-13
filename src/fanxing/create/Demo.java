package fanxing.create;
//泛型的声明在尖括号中进行<>
public class Demo<S> {
    //<T,U>为声明  泛型
    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        return null;
    }
static Integer[] ii={1,2};
    public static void main(String[] args) {
        copyOf(ii,2,String[].class);
    }
}
