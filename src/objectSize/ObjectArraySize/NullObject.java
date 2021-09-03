package objectSize.ObjectArraySize;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * 可以检测出 oop是否开启了内存优化 ，如果指针优化 那么oop占4个字节  如果没有 那么占8个字节
 * 因此 如果优化了 那么这个对象占用内存大小应该为16  没有优化 这个对象占用内存大小应该是24
 * @author 许鸿志
 * @since 2021/9/2
 */
public class NullObject {
    //在ArraySize中择机注释，平时 注释掉
    int value=0;
//    long aaa;
    public static void main(String[] args) {
        NullObject memoryAligning = new NullObject();
        long objectSize = ObjectSizeCalculator.getObjectSize(memoryAligning);
        System.out.println(objectSize);
    }
}
