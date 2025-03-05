package comput;

/**
 * @Author： hongzhi.xu
 * @Date: 2025/3/5 22:26
 * @Version 1.0
 */
public class BalanceOrderDO{

    /**
     * 主键
     */
    private Long orderId;
    /**
     * 剩余课时数
     */
    private Integer remainingClassHours;

    /**
     * 消费课时数
     */
    private Integer consumeClassHours;

    public BalanceOrderDO(Long orderId,  Integer remainingClassHours,Integer consumeClassHours) {
        this.orderId = orderId;
        this.consumeClassHours = consumeClassHours;
        this.remainingClassHours = remainingClassHours;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getRemainingClassHours() {
        return remainingClassHours;
    }

    public void setRemainingClassHours(Integer remainingClassHours) {
        this.remainingClassHours = remainingClassHours;
    }

    public Integer getConsumeClassHours() {
        return consumeClassHours;
    }

    public void setConsumeClassHours(Integer consumeClassHours) {
        this.consumeClassHours = consumeClassHours;
    }
}