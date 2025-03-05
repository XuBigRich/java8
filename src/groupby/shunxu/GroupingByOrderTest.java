package groupby.shunxu;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByOrderTest {
    public static void main(String[] args) {
        // 模拟数据
        List<TerRebateHeadReqVo> reqList = Arrays.asList(
                new TerRebateHeadReqVo(1002L, "B"),
                new TerRebateHeadReqVo(1001L, "A"),
                new TerRebateHeadReqVo(1003L, "C"),
                new TerRebateHeadReqVo(1001L, "D"),
                new TerRebateHeadReqVo(1002L, "E")
        );
        // 测试默认 HashMap 分组
        for (int i = 0; i < 1000; i++) {
            testHashMapGrouping(reqList);
        }
        // 测试 LinkedHashMap 分组（保留插入顺序）
//        testLinkedHashMapGrouping(reqList);
        // 测试 TreeMap 分组（按自然顺序排序）
//        testTreeMapGrouping(reqList);
    }

    // 测试默认 HashMap 分组
    private static void testHashMapGrouping(List<TerRebateHeadReqVo> reqList) {
        Map<Long, List<TerRebateHeadReqVo>> terReqMap = reqList.stream()
                .collect(Collectors.groupingBy(TerRebateHeadReqVo::getTerId));
        System.out.println("默认 HashMap 分组后的键顺序（可能不一致）：");
        for (Long terId : terReqMap.keySet()) {
            System.out.println(terId+" "+terReqMap.get(terId));
        }
    }

    // 测试 LinkedHashMap 分组（保留插入顺序）
    private static void testLinkedHashMapGrouping(List<TerRebateHeadReqVo> reqList) {
        Map<Long, List<TerRebateHeadReqVo>> linkedHashMap = reqList.stream()
                .collect(Collectors.groupingBy(
                        TerRebateHeadReqVo::getTerId,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
        System.out.println("\nLinkedHashMap 分组后的键顺序（保留插入顺序）：");
        for (Long terId : linkedHashMap.keySet()) {
            System.out.println(terId);
        }
    }

    // 测试 TreeMap 分组（按自然顺序排序）
    private static void testTreeMapGrouping(List<TerRebateHeadReqVo> reqList) {
        Map<Long, List<TerRebateHeadReqVo>> treeMap = reqList.stream()
                .collect(Collectors.groupingBy(
                        TerRebateHeadReqVo::getTerId,
                        TreeMap::new,
                        Collectors.toList()
                ));
        System.out.println("\nTreeMap 分组后的键顺序（按自然顺序排序）：");
        for (Long terId : treeMap.keySet()) {
            System.out.println(terId);
        }
    }
}

class TerRebateHeadReqVo {
    private Long terId;
    private String name;

    public TerRebateHeadReqVo(Long terId, String name) {
        this.terId = terId;
        this.name = name;
    }

    public Long getTerId() {
        return terId;
    }

    public String getName() {
        return name;
    }
    @Override
    public int hashCode() {
        // 自定义哈希值，增加哈希冲突
        return (int) (terId % 10);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TerRebateHeadReqVo that = (TerRebateHeadReqVo) obj;
        return Objects.equals(terId, that.terId);
    }
    @Override
    public String toString() {
        return "TerRebateHeadReqVo{" +
                "terId=" + terId +
                ", name='" + name + '\'' +
                '}';
    }
}
