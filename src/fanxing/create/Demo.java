package fanxing.create;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

/**
 * 泛型声明规范：
 *  类中的声明是在 类的后面加 尖括号
 *  方法中声明是在 返回值类型的 前面  加尖括号
 *
 * 泛型的运用：
 *  <S extends (T)String> >则表示(T)String是最高的，也就是说，可以表示所有继承于(T)String的（包括(T)String）
 *  <S super (T)String> 表示(T)String是最低的，也就是说，可以表示所有(T)String的父类（包括(T)String）
 */
//泛型的声明在尖括号中进行<>
public class Demo<S extends String> {
    //<T,U>为声明  泛型
    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T> newType) throws IllegalAccessException, InstantiationException {
        //newType 表示新数组的组件类型的 Class 对象   .建立一个类型为newType 长度未newLength的数组
        T[] sz= (T[]) Array.newInstance(newType, newLength);
       T a= newType.newInstance();
//        System.arraycopy(original,0,sz,0,1);
        int i=0;
        for(U u:original){
            T t=(T)u; //这样转换是一个弱引用 不会起到实际转换作用
//            sz[i]=t;  //因为是弱引用 所以 这个引用被T数组接收 会报类型转换异常（这个结论是错误的）
           /* Integer b=1;        //由这个示例可得 Integer 类型是不可以被强转为String类型的  也就是说 T t=(T)u;  虽然不会报错 但不会 进行转化
            String bb=(String)b;
            System.out.println(bb);*/
            System.out.println(newType.getName());
            if(u instanceof Integer){
                sz[i]= (T) u.toString();;
                i++;
            }
        }
        return sz;
    }
static Integer[] ii={1,2};
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
       String[] aaa =copyOf(ii,2,String.class);
        System.out.println(aaa[0]);
    }
    public static void test(){
        aaa(1,2);
    }
    public static void aaa(int... b){

    }
}
