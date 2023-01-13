package classDemo.abstrctLear;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 类需要实现 抽象类和接口的所有方法
 *
 * @author 许鸿志
 * @since 2021/9/11
 */
public class ClassRealize extends InterfaceAbstractDemo {

    @Override
    public void say() {

    }

    @Override
    public void face() {

    }
    public static void main(String[] args) {
        Set set=new HashSet<Integer>();
        Random random=new Random();

        while (set.size()!=100){
            int i = random.nextInt(1000);
            set.add(i);
        }
        System.out.println(set);

    }
}
