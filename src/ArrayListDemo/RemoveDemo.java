package ArrayListDemo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 移除容器元素
 * @author 许鸿志
 * @since 2022/6/16
 */
public class RemoveDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
        List<Integer> target = Arrays.asList(new Integer[]{1, 3, 6});
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
//            if (target.contains(integer)) {
//                iterator.remove();
//            }
            target.forEach(e -> {
                if (e.equals(integer)) {
                    iterator.remove();
                }
            });
        }
    }
}
