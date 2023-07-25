package jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;

/**
 *
 * -Xms2048m
 * -Xmx2048m
 * -Xmn1024m
 * -XX:+UseConcMarkSweepGC
 * -XX:SurvivorRatio=8
 * java -jar -Xms8192m  -Xmx8192m    -Xmn5120m
 * Xms表示初始化堆内存
 * -Xmx 表示最大堆内存
 * -Xmn表示新生代的内存
 * ******原来java的垃圾回收器在内存使用达到-Xms值的时候才会开始回收，如果两个值一样，那就意味着，只有当java使用完所有内存时才会回收垃圾，这样一来内存当然不停的涨。
 * -XX:SurvivorRatio=5 ，我准备扩大  SurvivorRatio，避免让 对对象直接进入老年代
 * 老年代大小 = 堆内存大小 - 新生代大小
 *
 * -XX:SurvivorRatio=8表示新生代的Eden占8/10，S1和S2各占1/10.
 * 因此Eden的内存大小为：0.8*1024*1024*1024字节 约为819**1024*1024
 *
 * @Author： hongzhi.xu
 * @Date: 2023/4/11 11:17 上午
 * @Version 1.0
 */
public class MemoryInfo {
    public static void main(String[] args) {
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
            byte[] array = new byte[6000];//734003216
            System.out.println(memoryPoolMXBean.getName() + "  总量:" + memoryPoolMXBean.getUsage().getCommitted() + "   使用的内存:" + memoryPoolMXBean.getUsage().getUsed());
        }

    }
}
