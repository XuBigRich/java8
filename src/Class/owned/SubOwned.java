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
        //尝试获取父类
        final Method ex = this.getClass().getMethod("ex", String.class, String.class);
        ex.invoke(ex, "1", "2");
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        SubOwned subOwned = new SubOwned();
        subOwned.exx();
    }
}
