package groupby;

import java.math.BigDecimal;

/**
 * @Author： hongzhi.xu
 * @Date: 2022/8/27 4:01 下午
 * @Version 1.0
 */
public class CacheStudentExamScore {
    public CacheStudentExamScore(Integer stata, BigDecimal score, BigDecimal avgScore) {
        this.stata = stata;
        this.score = score;
        this.avgScore = avgScore;
    }

    private Integer stata;
    private BigDecimal score;
    private BigDecimal avgScore;

    public Integer getStata() {
        return stata;
    }

    public void setStata(Integer stata) {
        this.stata = stata;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(BigDecimal avgScore) {
        this.avgScore = avgScore;
    }

}
