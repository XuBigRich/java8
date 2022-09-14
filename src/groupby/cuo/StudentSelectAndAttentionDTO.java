package groupby.cuo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;

/**
 * @author 李树敏
 * @date 2021/9/26 9:48
 */
public class StudentSelectAndAttentionDTO {


    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 学生得分分布情况
     */
    public Set<StudentScoreDistribution.EntryNodeImpl> studentScoreDistributions;

    public class StudentScoreDistribution<K, V> extends HashMap<BigDecimal, Integer> {

        EntryNodeImpl<K, V>[] table;

        public class EntryNodeImpl<K, V> implements Entry<BigDecimal, Integer> {
            public BigDecimal score;
            public Integer nums;

            @Override
            public BigDecimal getKey() {
                return score;
            }

            @Override
            public Integer getValue() {
                return nums;
            }

            @Override
            public Integer setValue(Integer value) {
                this.setValue(value);
                return nums;
            }
        }
    }

}
