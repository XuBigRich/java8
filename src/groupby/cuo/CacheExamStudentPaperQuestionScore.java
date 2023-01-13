package groupby.cuo;

import java.math.BigDecimal;

/**
 * <p>
 * 缓存--学生次考试的每个小题的得分情况表
 * </p>
 *
 * @author wcs
 * @since 2021-09-08
 */
public class CacheExamStudentPaperQuestionScore{
    private BigDecimal score;

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}