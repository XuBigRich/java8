package Class.owned;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 尝试调用父类的私有方法
 * @Author： hongzhi.xu
 * @Date: 2023/1/13 5:28 下午
 * @Version 1.0
 */

public class SubOwned extends Owned{

    public void exx() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取父类的所有方法
        final Method[] eee = this.getClass().getSuperclass().getMethods();
        //在本对象种 直接尝试获取父类私有 方法
//        final Method ex = this.getClass().getMethod("ex", String.class, String.class);
        //在本类中 强制 获取父类私有方法
//        final Method ex = this.getClass().getDeclaredMethod("ex", String.class, String.class);
        //获取到本类的父类，然后强制获取父类私有方法
//        final Method ex = this.getClass().getSuperclass().getDeclaredMethod("ex", String.class, String.class);
//        ex.setAccessible(true);
//        ex.invoke(this, "1", "2");
        System.out.println(this);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        SubOwned subOwned = new SubOwned();
        subOwned.exx();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
