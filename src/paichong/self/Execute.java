package paichong.self;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

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

    /**
     * lambda 排序去重
     *
     * @param targetList
     * @return
     */
    public List distinctSort(List<Target> targetList) {
        return targetList.stream().collect(
                collectingAndThen(
                        toCollection(
                                () -> new TreeSet<>(Comparator.comparing(a -> a.sort))
                        ), ArrayList<Target>::new));
    }

    public Set<Target> distinct(List<Target> targetList) {
        return targetList.stream().collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Execute execute = new Execute();
        //排重待处理容器
        List<Target> targetList = new ArrayList<>();
        //给容器添加对象
        execute.addObject(targetList);
        //普通去重
        Set<Target> s = execute.distinct(targetList);
        System.out.println(s);
        //排序
        List<Target> sr = execute.distinctSort(targetList);
        System.out.println(sr);
    }
}
