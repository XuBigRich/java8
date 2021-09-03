package objectSize;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import objectSize.utils.ClassIntrospector;
import objectSize.utils.ObjectInfo;

/**
 *
 *   开启(-XX:+UseCompressedOops) 可以压缩指针。
 *   关闭(-XX:-UseCompressedOops) 可以关闭压缩指针。
 * 计算数组大小
 * 8(_mark) + 8(oop指针)+4(ObjectD[]数组长度) +8(nullObjects[0]_mark) +8(nullObjects[0],_mark)+ 8(nullObjects[0],oop指针)+8(nullObjects[1],_mark)+ 8(nullObjects[1],oop指针)
 * <p>
 *
 * 当注释掉value
 * ObjectC的Shallow size = 8(_mark) + 8(oop指针) =16
 * nullObjects对象变量 =  8(_mark) + 8(oop指针)  + 4(ObjectD[]长度) +4（padding） = 24
 * NullObject对象长度 = 8(_mark) + 8(oop指针) = 16*2
 *  72
 *
 * 当放开 value
 * ObjectC的Shallow size = 8(_mark) + 8(oop指针) =16
 * nullObjects对象变量 =  8(_mark) + 8(oop指针)  + 4(ObjectD[]长度) +4（padding） = 24
 * NullObject对象 = 8(_mark) + 8(oop指针) +4（value）padding）= 24*2
 *  此时 nullObjects对象变量 与 NullObject对象  的 4 （ObjectD） 会进行内存对齐，这样 依然占用72
 * 所以我认为 应该是80
 *+
 * @author 许鸿志j
 * @since 2021/9/2
 */
public class ArraySize {
    NullObject[] nullObjects = new NullObject[2];
    public ArraySize() {
        nullObjects[0] = new NullObject();
        nullObjects[1] = new NullObject();
    }

    public static void main(String[] args) throws IllegalAccessException {
        ArraySize memoryAligning = new ArraySize();
        long objectSize = ObjectSizeCalculator.getObjectSize(memoryAligning);
        System.out.println(objectSize);


        //下面这个工具无法计算 引用对象的数据大小

        final ClassIntrospector ci = new ClassIntrospector();
        ObjectInfo res;

        res = ci.introspect(memoryAligning);
        System.out.println(res.getDeepSize());

    }
}
