package Cache;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IntegerCache.java
 * @Description 本实例 主要探究 Integer 中 在 -128 到 127 范围内的  缓存机制
 * @createTime 2019年04月17日 10:19:00
 */
public class IntegerCache {
    Integer integer=123;
    Integer integer1=Integer.valueOf(123);  // 入口

    public static void main(String[] args) {
        Integer integer=new Integer(123);
    }
}
/*
*     缓存 源码 + 理解解析 如下：
*  private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];
        static {

            int h = 127;
            String integerCacheHighPropValue =
                sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");  //在jvm虚拟机中 获取 high的值
            if (integerCacheHighPropValue != null) {    //如果  high值不为空
                try {
                    int i = parseInt(integerCacheHighPropValue);   //i等于 这个字符串  字符串进行转换为 int 类型
                    i = Math.max(i, 127);							//  i的值 通过 比较i与127   他俩 谁大等于谁
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);		// h的值 通过   比较i 与 0x7fffffff-128 他俩谁小等于谁
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }													//if代码块的意义就是 确保从 jvm虚拟机中 取出high值  这个值 不能小于127不能大于  2147483647-128  否则使用 127 为h
            high = h;

            cache = new Integer[(high - low) + 1];     //建立一个数组  这个cache  其 长度 等于   high+128+1 （意思就是 high 到 low  有几个 数字 就是他数组的大小）
            int j = low;  								//j=-128
            for(int k = 0; k < cache.length; k++)    // 遍历 数组 cache
                cache[k] = new Integer(j++);			//给数组中每一个元素赋值一个 Ingeger 值为j++  一直到 hight   （重要！！！！！）
                		0 — -128  1 - -127
            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;    //判断 high是否大于等于127
        }

        private IntegerCache() {}

        //根据 26 行代码 可以看出 在 Integer被初始化的时候  其实 Integer的缓存池中 就已经 存在  -126 到 high 的 所有 数字了
    }

    IntegerCache.cache[i + (-IntegerCache.low)];   // 确定 - IntegerCache.low 相当于 归位  于0
* */
