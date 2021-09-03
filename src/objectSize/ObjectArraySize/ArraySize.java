package objectSize.ObjectArraySize;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import objectSize.simpleArraySize.SimpleArraySize;
import objectSize.utils.ClassIntrospector;
import objectSize.utils.ObjectInfo;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 开启(-XX:+UseCompressedOops) 可以压缩指针。
 * 关闭(-XX:-UseCompressedOops) 可以关闭压缩指针。
 * 计算数组大小
 * 8(_mark) + 8(oop指针)+4(ObjectD[]数组长度) +8(nullObjects[0]_mark) +8(nullObjects[0],_mark)+ 8(nullObjects[0],oop指针)+8(nullObjects[1],_mark)+ 8(nullObjects[1],oop指针)
 * <p>
 * <p>
 * 当注释掉(没有)value
 * ArraySize的 size = 8(_mark) + 8(oop指针)+  4(NullObject[]引用)  （绝对正确）
 * nullObjects对象变量 =  8(_mark) + 8(oop指针)  + 4(ObjectD[]长度)   （绝对正确）
 * 4(NullObject 引用）*2  =8  （绝对正确）
 * 48 这样算 应该是48 ，在不开启oop优化的状态下，但是 不知道咋回事jvm好像强制开启 oop 必须 大小为4 这样经过优化  就又变成了40
 * <p>
 * 然后放开默认的构造函数
 * 将添加两个 NullObject 对象
 * 8(_mark) + 8(oop指针) =16 *2  =32
 * <p>
 * 最终40+32 =72
 * <p>
 * 当放开 value
 * 开头部分 计算不变
 * ArraySize的size = 8(_mark) + 8(oop指针))+  4(NullObject[]引用)
 * nullObjects对象变量 =  8(_mark) + 8(oop指针)  + 4(ObjectD[]长度)
 * 另外数组大小为2 所以需要两个引用  一个引用 为4  需要2*4  =8 （确定没错）
 * 然后放开默认的构造函数
 * 将添加两个 NullObject 对象
 * 8(_mark) + 8(oop指针) =16 *2  =32
 * <p>
 * 最终40+32 =72
 * <p>
 * 下面开始改变
 * NullObject对象 = (  8(_mark) + 8(oop指针)  +4（（value）padding）  )*2= ？  40/48
 * <p>
 * （最终出现两个方案）
 * 72+40=112    72*48=120
 * 这两个方案区别在于  NullObject中的value是否会进行内存对齐，如果内存对齐 那么 结果应该是40  如果是48 那么 同一数组的不同对象 不会进行内存对齐
 * <p>
 * 最终得到答案 为40  得知会进行内存对其
 * <p>
 *
 * @author 许鸿志
 * @since 2021/9/2
 */
public class ArraySize {
    NullObject[] nullObjects = new NullObject[2];

    public ArraySize() {
        nullObjects[0] = new NullObject();
        nullObjects[1] = new NullObject();
    }

    public static void offset() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        Field[] fields = ArraySize.class.getDeclaredFields();
        Comparator<Long> comparator = Long::compareTo;
        Map<Long, String> map = new TreeMap(comparator);
        for (Field f : fields) {
            //打印出属性在对象中的偏移量  数值越小 越接近对象初始位置
            System.out.println(f.getName() + " offset: " + unsafe.objectFieldOffset(f));
            map.put(unsafe.objectFieldOffset(f), f.getName());
        }
        map.forEach((k, v) -> {
            System.out.println(v + ":" + k);
        });
    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        ArraySize memoryAligning = new ArraySize();
        long objectSize = ObjectSizeCalculator.getObjectSize(memoryAligning);
        System.out.println(objectSize);


        //下面这个工具无法计算 引用对象的数据大小

        final ClassIntrospector ci = new ClassIntrospector();
        ObjectInfo res;

        res = ci.introspect(memoryAligning);
        System.out.println(res.getDeepSize());
        offset();
    }
}
