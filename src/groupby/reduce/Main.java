package groupby.reduce;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return "TerRebateHeadReqVo{" +
                "terId=" + terId +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // 准备数据
        List<TerRebateHeadReqVo> reqList = Arrays.asList(
                new TerRebateHeadReqVo(1L, "A"),
                new TerRebateHeadReqVo(2L, "B"),
                new TerRebateHeadReqVo(3L, "C"),
                new TerRebateHeadReqVo(4L, "D"),
                new TerRebateHeadReqVo(5L, "E")
        );

        // 多次运行分组代码
        for (int i = 0; i < 1000000; i++) {
            // 分组
            Map<Long, List<TerRebateHeadReqVo>> terReqMap = reqList.stream()
                    .collect(Collectors.groupingBy(TerRebateHeadReqVo::getTerId));

            // 记录 terId 顺序
            List<Long> terIds = new ArrayList<>(terReqMap.keySet());
            System.out.println("Run " + (i + 1) + " terId order: " + terIds);
        }
    }
}
