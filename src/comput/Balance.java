package comput;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： hongzhi.xu
 * @Date: 2025/3/5 22:26
 * @Version 1.0
 */
public class Balance {
    public static List<Long> deductionOrderBalanceSelf(Integer deductionClassHoursNum, List<BalanceOrderDO> normalBalanceOrderDOS) {
        List<Long> orderIds = new ArrayList<>();
        //要扣减的课时总数
        Integer classHoursNum = deductionClassHoursNum;
        //如果classHoursNum为正数 说明余额不够需要使用下一个订单扣款
        for (int index = 0; classHoursNum > 0; index++) {
            BalanceOrderDO balanceOrderDO = normalBalanceOrderDOS.get(index);
            classHoursNum = classHoursNum - balanceOrderDO.getRemainingClassHours();
            orderIds.add(balanceOrderDO.getOrderId());
            if (classHoursNum <= 0) {
                final int orderConsumerClassHors = Math.abs(classHoursNum);
                //增加消费额度
                balanceOrderDO.setConsumeClassHours(balanceOrderDO.getConsumeClassHours() + (balanceOrderDO.getRemainingClassHours()-orderConsumerClassHors));
                //扣减余额
                balanceOrderDO.setRemainingClassHours(orderConsumerClassHors);
                break;
            } else {
                balanceOrderDO.setConsumeClassHours(balanceOrderDO.getConsumeClassHours() + balanceOrderDO.getRemainingClassHours());
                balanceOrderDO.setRemainingClassHours(0);
            }
        }
        return orderIds;
    }

    public static void main(String[] args) {
        // 构造测试数据
        List<BalanceOrderDO> orders = new ArrayList<>();
        orders.add(new BalanceOrderDO(1L, 3, 1)); // 订单1，剩余3课时
        orders.add(new BalanceOrderDO(2L, 4, 0)); // 订单2，剩余4课时
        orders.add(new BalanceOrderDO(3L, 5, 0)); // 订单2，剩余4课时

        // 调用原方法扣除5课时
        List<Long> resultOrderIds = deductionOrderBalanceSelf(5, orders);

        // 打印结果
        System.out.println("涉及订单ID: " + resultOrderIds);
        for (BalanceOrderDO order : orders) {
            System.out.printf("订单%d: 剩余=%d, 消耗=%d\n",
                    order.getOrderId(), order.getRemainingClassHours(), order.getConsumeClassHours());
        }
    }
}
