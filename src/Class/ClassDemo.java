package Class;

/*
* 所有的类都是Class类的对象
* */
public class ClassDemo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Xu xu= new Xu();

        /*
         * 验证Xu类是 Class类的对象
         * */

        //第一种方式
        Class class1=Xu.class;
        //第二种方式
        Class class2=xu.getClass();
        //第三种方式
        /*
        * 这种方法 不仅可以 表示类的 类类型 也可以 表示 动态加载类
        *
        * 何为 动态加载类；编译时加载类 是静态加载类，运行时刻 加载类  是动态加载类
        * 动态加载类  用 才 加载  不用  不加载  ；
        * new是 静态 加载类  在 编译的 时候 会  一次性 加载所有 类 ，如果 一个 类 不存在  就 无法运行；
        * 而 动态加载类  ，若 有一个 类 不存在 ，但如果这个类 用不到 则可以执行编译成功
        * */
        Class class3 = Class.forName("Class.Xu");

        System.out.println(class1);//输出类的 类型  class Class.Xu；
        // 说明Xu 类 的 类型为class Class.Xu

        //对比同一个 类  类的 类类型 是否相同
        System.out.println(class1==class2);
        System.out.println(class3==class2);

        //使用 类的 类类型 创建 一个 类的实例
        Xu fmj= (Xu)class2.newInstance();
        fmj.aaa();
    	}
    Class<? extends Object> c=Xu.class;
}
class Xu{
//   创建实例对象 需要有无参数的 构造函数
//    private Xu(){};
        public void aaa(){
            System.out.println("啊啊啊");
        }
        }
