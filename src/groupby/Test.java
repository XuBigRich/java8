package groupby;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 计算相同状态下的 分值总和
 *
 * @Author： hongzhi.xu
 * @Date: 2022/8/27 4:00 下午
 * @Version 1.0
 */
public class Test {
    public static List<CacheStudentExamScore> studentExamScores = new ArrayList<>();

    public static void add() {
        CacheStudentExamScore cse1 = new CacheStudentExamScore(1, BigDecimal.valueOf(2), null);
        studentExamScores.add(cse1);
        CacheStudentExamScore cse2 = new CacheStudentExamScore(1, BigDecimal.valueOf(3), null);
        studentExamScores.add(cse2);
        CacheStudentExamScore cse3 = new CacheStudentExamScore(2, BigDecimal.valueOf(2), null);
        studentExamScores.add(cse3);
    }

    public static AtomicReference<BigDecimal> get() {
        return new AtomicReference<>(BigDecimal.ZERO);
    }

    public static void main(String[] args) {
        add();
        Map<Integer, AtomicReference<BigDecimal>> studentExamMa1p = studentExamScores.stream().collect(
                Collectors.groupingBy(CacheStudentExamScore::getStata,
                        Collector.of(Test::get,
                                //累加函数
                                (bigDecimal, cacheStudentExamScore) -> {
                                    bigDecimal.set(bigDecimal.get().add(cacheStudentExamScore.getScore()));
                                }, (a, b) -> {
                            //替换函数
                                    a.set(a.get().add(b.get()));
                                    return a;
                                })));
        System.out.println(studentExamMa1p);
    }
}
