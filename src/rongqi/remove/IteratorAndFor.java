package rongqi.remove;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 许鸿志
 * @since 2021/6/19
 */
public class IteratorAndFor {
    private List<Integer> list = new ArrayList();

    public void addValues() {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public void useIterator() {
        Iterator<Integer> integerIterator = list.listIterator();
        while (integerIterator.hasNext()) {
            Integer item = integerIterator.next();
            if (item.equals(1)) {
//               通过迭代器移除会更新  expectedModCount 属性  执行 expectedModCount = modCount;
                integerIterator.remove();
            }
        }
    }

    public void useFor() {
        //使用for(:) 其实是使用的迭代器的方式遍历
        for (Integer item : list) {
            if (item.equals(3)) {
                // 通过list移除 不会更新 expectedModCount ，所以会造成 expectedModCount ！= modCount  导致异常抛出
                list.remove(item);
            }
        }
    }

    public void useFor2() {
        //使用常规for循环方式遍历列表
        for (int i = 0; i <= list.size(); i++) {
            Integer target = list.get(i);
            if (target.equals(3)){
                // 通过list移除 不会更新 expectedModCount ，所以会造成 expectedModCount ！= modCount  导致异常抛出
                list.remove(target);
            }
        }
    }

    public static void main(String[] args) {
        IteratorAndFor iteratorAndFor = new IteratorAndFor();
        iteratorAndFor.addValues();
//        iteratorAndFor.useIterator();
        System.out.println(iteratorAndFor.list);
        // useFor()
//        iteratorAndFor.useFor();
        System.out.println(iteratorAndFor.list);
        //useFor2()
        iteratorAndFor.useFor2();
        System.out.println(iteratorAndFor.list);
    }
}
