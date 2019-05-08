package leixingzhuanhuan.duixiangleixingzhuanhuan;
/*
* 关于对象类型转换 ：
* 若 子类 与 父类实例变量 相同； 谁的类型 就用 谁的实例变量；  ”内存地址不一致“
* 若要使用父类内存地址 获取 实例变量 必须转换 为父类；
*
* 若 子类 没有 覆盖 父类 实例变量；  则 子类 与 父类 共用一个 实例变量  且  ”内存地址一致“
* 子类若使用父类 实例变量  无需转换 可直接使用；
*
* 对象类型转换 不会丢失 原来的 类类型
* */
public class Student {
   public static void main(String[] args) {
       Teacher teacher=new Teacher();
       People people=teacher;  // 向上转型覆盖了子类的name实例方法
       people.name="liyanbing";  //初始化父类 name属性 此处赋值 是给 父类name 属性赋值
       teacher.name="zhangshuhong";  //初始化子类 name属性  此处赋值 是给 子类name 属性赋值
       System.out.println(teacher.sex);//初始化 子类必定 初始化 父类 所以子类拥有父类 所有 属性;
       System.out.println(teacher.name);
       System.out.println(((People)teacher).name);
       //====================================================
       System.out.println( people.name.hashCode());
       System.out.println(((People)teacher).name.hashCode());
       System.out.println(teacher.name.hashCode());
//        证明了向上 转换后的实例变量地址与 父类实例变量地址 一致  ； 而 转型后于 转型前 的 实例变量地址 不一致；
       //==========================================
       System.out.println(teacher.hashCode());
       System.out.println(people.hashCode());
//       证明了 teacher 与people指向的是同一内存地址
       //=============================================
       System.out.println(teacher.hashCode());
       System.out.println(((People)teacher).hashCode());
//       证明了 转型前与转型后是同一内存地址
   	}
}
class People{
    String name;
    String sex="m";
}
class  Teacher extends People{
    String name;

}