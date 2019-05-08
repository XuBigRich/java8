package annotationzhujie.one;

import java.util.ArrayList;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserEntiy.java
 * @Description TODO
 * @createTime 2019年01月28日 10:38:00
 */
/*
* 注解概述与内置注解
* */
public class UserEntiy extends Object {
    /*
    * @Override 注解的功能 作用
    * 标示此类 是重写 父类的方法
    * 校验此类是 子类 重写 父类 的方法
    * */
    @Override    //标示子类重写父类
    public String toString(){
        return super.toString();
    }
    //@Override    //标示子类重写父类  会有校验功能 查看时请打开 注释
    public String toString11(){
        return super.toString();
    }
    @Deprecated   //@Deprecated  注解标识 表示过时了 当使用时  就会出现杠杠
    public void add(){

    }

    public static void main(String[] args) {
        //@Deprecated  注解标识 表示过时了
        UserEntiy userEntiy=new UserEntiy();
        userEntiy.add();
        ArrayList arrayList=new ArrayList();
    	}
}
