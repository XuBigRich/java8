package objectSize;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.List;

/**
 * 探究类在jvm上面所占用字节大小
 */

//这个类理论上他所含义的属性一共占用 7*8 =56个字节 （一个缓存行有64个字节可供存储）
public final class VolatileLong {
    //一个long类型占8个字节（byte）
    public volatile long value = 0L;
    //这个是要被注释掉的  ，他注释与不注释会严重影响程序执行时间
    public long p1, p2, p3, p4, p5, p6;

    //在Java中 计算 对象所占字节大小
    public static void main(String[] args) {
        VolatileLong volatileLong = new VolatileLong();
        //64位操作系统 class指针空间大小8字节，MarkWord是8字节  所以只对象头就16字节
        //long占8字节 这里有7个 long 所以占56个字节
        //于是这个对象应该是16+56 在jvm中占72个字节
        long objectSize = ObjectSizeCalculator.getObjectSize(volatileLong);
        System.out.println(objectSize);
    }
}
