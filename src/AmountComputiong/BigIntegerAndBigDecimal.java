package AmountComputiong;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @author 许鸿志
 * @since 2022/3/7
 */
public class BigIntegerAndBigDecimal {
    public static void main(String[] args) {
        long at = System.currentTimeMillis();
        BigInteger a = BigInteger.valueOf(1000);
        BigInteger b = BigInteger.valueOf(7);
        //前六节价格
        BigInteger BigIntegerGg = a.divide(b);
        System.out.println("BigInteger类型的前六节课价格：" + BigIntegerGg);
        System.out.println("最后一节课价格:" + a.subtract(BigInteger.valueOf(6).multiply(BigIntegerGg)));
        long bt = System.currentTimeMillis();
        System.out.println(bt - at);

        long ct = System.currentTimeMillis();
        BigDecimal c = BigDecimal.valueOf(10);
        BigDecimal d = BigDecimal.valueOf(7);
        //前六节价格
        BigDecimal BigDecimalGg = c.divide(d, 2, RoundingMode.DOWN);
        System.out.println("BigDecimal类型的前六节课价格：" + BigDecimalGg);
        System.out.println("最后一节课价格:" + c.subtract(BigDecimal.valueOf(6).multiply(BigDecimalGg)));
        long et = System.currentTimeMillis();
        System.out.println(et - ct);

        //BigDecimal精度丢失问题
        BigDecimal jddsa = new BigDecimal(1.01);
        BigDecimal jddsb = new BigDecimal(1.02);
        System.out.println(jddsa.add(jddsb));
        //解决方案，使用string就可以解决精度丢失问题
        BigDecimal jddssa = new BigDecimal("1.01");
        BigDecimal jddssb = new BigDecimal("1.02");
        System.out.println(jddssa.add(jddssb));
        //使用valueOf也可以解决精度问题，其底层是将Double转为String，在转为BigDecimal
        BigDecimal jddsva = BigDecimal.valueOf(1.01);
        BigDecimal jddsvb = BigDecimal.valueOf(1.02);
        System.out.println(jddsva.add(jddsvb));
    }
}
