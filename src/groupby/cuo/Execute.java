package groupby.cuo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 这是一段 有问题的代码 （但是我感觉思路可行）
 * 我的本意是 统计各个得分的人数分布。
 * 将他们统一的放入studentSelectAndAttentionDTO 对象的  StudentScoreDistribution 属性
 * 为此我重写了 StudentScoreDistribution （实现自Map），让他们的 存储集合 使用外部类的 studentScoreDistributions
 * 在groupingBy 中 ，我将 分数为key， 每一个都创建一个 StudentScoreDistribution，当产生冲突合并时 我将两数相加
 * @author 许鸿志
 * @since 2022/9/14
 */
public class Execute {
    // TODO
    public static List buildData(){
        List<CacheExamStudentPaperQuestionScore> cacheExamStudentPaperQuestionScores = new ArrayList<>();
        CacheExamStudentPaperQuestionScore cacheExamStudentPaperQuestionScore = new CacheExamStudentPaperQuestionScore();
        cacheExamStudentPaperQuestionScore.setScore(BigDecimal.valueOf(1));
        cacheExamStudentPaperQuestionScores.add(cacheExamStudentPaperQuestionScore);
        CacheExamStudentPaperQuestionScore cacheExamStudentPaperQuestionScore1 = new CacheExamStudentPaperQuestionScore();
        cacheExamStudentPaperQuestionScore1.setScore(BigDecimal.valueOf(1));
        CacheExamStudentPaperQuestionScore cacheExamStudentPaperQuestionScore2 = new CacheExamStudentPaperQuestionScore();
        cacheExamStudentPaperQuestionScore2.setScore(BigDecimal.valueOf(3));
        cacheExamStudentPaperQuestionScores.add(cacheExamStudentPaperQuestionScore2);
        CacheExamStudentPaperQuestionScore cacheExamStudentPaperQuestionScore3 = new CacheExamStudentPaperQuestionScore();
        cacheExamStudentPaperQuestionScore3.setScore(BigDecimal.valueOf(1));
        return cacheExamStudentPaperQuestionScores;
    }
    public static void main(String[] args) {
        List<CacheExamStudentPaperQuestionScore> cacheExamStudentPaperQuestionScores = buildData();

        StudentSelectAndAttentionDTO studentSelectAndAttentionDTO = new StudentSelectAndAttentionDTO();
        StudentSelectAndAttentionDTO.StudentScoreDistribution collect = cacheExamStudentPaperQuestionScores.stream().collect(Collectors.groupingBy(
                CacheExamStudentPaperQuestionScore::getScore,
                () -> studentSelectAndAttentionDTO.new StudentScoreDistribution(),
                Collector.of(() -> 1, (old, newly) -> {
                }, Integer::sum)));
        System.out.println(studentSelectAndAttentionDTO);
    }

}
