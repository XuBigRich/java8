package jicheng.mianshiti.team1;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName This.java
 * @Description 这样做的 目的是因为 子类 初始化 必须要先 初始化 父类
 *                  而父类 只有一个 有参构造函数 所以你要用 super给父类 传值初始化
 * @createTime 2019年04月23日 10:31:00
 */
public class This extends Super {
    //public This() {}  //这样是编译 不通过的   ，因为 父类 没有无参的构造函数 （或默认的 构造函数 因为 父类 只有一个 有参的 构造函数）
    public This(String a) {
        super(a);// 这样就可以了
    }
}
