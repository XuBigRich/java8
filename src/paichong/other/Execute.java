package paichong.other;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 此方法重写了set排重 通过重构Target中的 hashCode 和equals 来达到 使用set去重的效果
 *
 * @author 许鸿志
 * @since 2021/5/19
 */
public class Execute {
    //容器中放置对象
    public void addObject(List<Target> targets) {
        //创建张三 对象
        Target target1 = new Target();
        target1.setName("张三");
        List<String> tag1 = new ArrayList<>();
        tag1.add("a");
        target1.setTag(tag1);
        target1.setSort(3);


        //创建李四对象
        Target target2 = new Target();
        target2.setName("李四");
        List<String> tag2 = new ArrayList<>();
        tag2.add("a");
        //重复控制器
//        tag2.add("b");
        target2.setSort(2);
        target2.setTag(tag2);


        //创建王五对象
        Target target3 = new Target();
        target3.setName("王五");
        List<String> tag3 = new ArrayList<>();
        tag3.add("b");
        target3.setSort(1);
        target3.setTag(tag3);


        //将张三和李四和王五放入待处理容器
        targets.add(target1);
        targets.add(target2);
        targets.add(target3);
    }

    public List<Target> distinct(List targetList) {
        List<Target> payParentInsteadVOS1 = (List<Target>) targetList.stream().filter(distinctByKey(Target::getTag)).collect(Collectors.toList());
        return payParentInsteadVOS1;
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static void main(String[] args) {
        Execute execute = new Execute();
        //排重待处理容器
        List<Target> targetList = new ArrayList<>();
        execute.addObject(targetList);
        List<Target> s=  execute.distinct(targetList);
        System.out.println(s);
    }
}
