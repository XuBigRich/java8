package groupby.shunxu;

import java.util.*;
import java.util.stream.Collectors;
public class HashMapOrderTest {
    public static void main(String[] args) {
        // 模拟数据
        List<TerRebateReqVo> reqList = new ArrayList<>();
        for (long i = 1; i <= 1000; i++) {
            reqList.add(new TerRebateReqVo(i, "Item" + i));
        }
        // 多次运行，观察 HashMap 的键顺序
        for (int i = 0; i < 10; i++) {
            System.out.println("第 " + (i + 1) + " 次运行：");
            testHashMapGrouping(reqList);
        }
    }
    // 测试默认 HashMap 分组
    private static void testHashMapGrouping(List<TerRebateReqVo> reqList) {
        Map<Long, List<TerRebateReqVo>> terReqMap = reqList.stream()
            .collect(Collectors.groupingBy(TerRebateReqVo::getTerId));
        System.out.println("默认 HashMap 分组后的键顺序（可能不一致）：");
        for (Long terId : terReqMap.keySet()) {
            System.out.print(terId + " ");
        }
        System.out.println("\n");
    }
}
 class TerRebateReqVo {
    private Long terId;
    private String name;
    public TerRebateReqVo(Long terId, String name) {
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
        TerRebateReqVo that = (TerRebateReqVo) obj;
        return Objects.equals(terId, that.terId);
    }
}
