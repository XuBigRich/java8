package Class.fanshe.getInteface;

/**
 * 通过Class对象的getInterfaces方法
 * 可以获得改类实现的接口
 * 返回形式默认是一个数组
 */
public class GetIntefaceDemo {
    public static void main(String args[]){
        LiuDeHuaStar liuDeHua = new LiuDeHuaStar();
        liuDeHua.say();
        liuDeHua.dance("");
        liuDeHua.sing("");
        System.out.println("---------------");
        Class<?>[] string=liuDeHua.getClass().getInterfaces();
        for(Class c:string){
            System.out.println(c);
        }
        Class<?> string01 = liuDeHua.getClass().getInterfaces()[0];
        //可以获得
        Class<Person> string02 = (Class<Person>) liuDeHua.getClass().getInterfaces()[1];
        System.out.println(string01);
        System.out.println(string02);
    }
}
