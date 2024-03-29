package objectSize.ObjectSize;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import objectSize.ObjectArraySize.NullObject;
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
 * <p>
 * 前置基础知识：
 * byte 可以在内存的任何位置，
 * Boolean 类型 可以在 内存的任意位置
 * char类型 只能在内存的2*n（二的倍数） 的位置
 * short  类型 只能在内存的2*n（二的倍数） 的位置
 * int 类型则只能在内存的 4*n （四的倍数）的位置
 * long 类型 只能在内存的 8*n （八的倍数）的位置
 * float 类型 只能在内存的 4*n （四的倍数）的位置
 * double 类型 只能在内存的 8*n （八的倍数）的位置
 * 一个未初始化的对象索引(包括数组索引) ,如obj2  类型则只能在内存的 4*n （四的倍数）的位置
 * 一个类中的对象 需要包含  是8(_mark) + 4(oop指针)+数据的大小长度 （且这个对象所在内存位置必须在4*n （四的倍数）的位置）
 * 但此处注意  NullObject obj3 = new NullObject(); 其实是 包含索引与对象的
 * 另外指出数组，数组在对象中只存引用 ，并不存实体对象，他与当前对象不是一块连续的内存地址
 * <p>
 * 但他们不管最终是多少，整个对象都将补齐到为8的倍数
 * <p>
 * 可以发现规律，他们都是需要在自己的大小整数倍上面的对应位置上。
 * <p>
 * 内存对齐   这个地方有个坑 就是oop 压缩  我看Java8默认都是开启的  所以oop默认是占用4个字节大小
 * <p>
 * 常规状态下:
 * 这个对象的大小应该是8(_mark) + 8(oop指针) + 4(str) + 1(b1) + 1(b2) + 4(i1)  + 4(i2) + 1(b3)  = 31byte
 * 然而计算机 会在处理对象内存时进行对齐  （使用padding对齐）
 * 就变成了 8(_mark)  、 8(oop指针)  、 4(str)+1(b1)+1(b2)+2(padding) 、 4(i1)+ 4(i2) 、 1(b3)+7(padding) = 40byte   补齐之后 变成了40byte
 * <p>
 * 通过运行main方法  实际计算  这个类  只占用了32个字节 这是为什么呢？？而我们通过理论运算这个类是占用了40个byte的，是我们的计算方式错了吗？
 * <p>
 * 其实：
 * HotSpot（虚拟机）创建的对象的字段会先按照给定顺序排列一下,默认的顺序如下，从长到短排列，引用排最后:  long/double --> int/float -->  short/char --> byte/boolean --> Reference
 * 这个顺序可以使用JVM参数:  -XX:FieldsAllocationSylte=0(默认是1)来改变。
 * 我们使用sun.misc.Unsafe对象的objectFieldOffset方法来验证一下:
 * 执行完 我们得到了 新的属性排列顺序 i1  i2  b1  b2  b3  str  obj
 * <p>
 * 再次计算   8(_mark)  、 8(oop指针)  、 4(i1)+ 4(i2) 、 1（b1） + 1（b2）+  1（b3）+ 4（str）+1 (padding)  =32 byte
 * <p>
 * <p>
 * 在优化的状态下，忘记上面的计算。
 * 如果开启了oop压缩   但下面例子都是基于 不开启oop压缩的基础上 进行的
 * 就变成了 8(_mark)  、 4(oop指针) +4(str) 、 1(b1)+1(b2)+2(padding)+4(i1) 、  4(i2)+ 1(b3)+3(padding) = 32byte   补齐之后 变成了32byte
 *
 * @author 许鸿志
 * @since 2021/9/2
 */
public class MemoryAligning {
    String str;  // 4
    int i1; // 4
    byte b1; // 1
    byte b2; // 1
    int i2; // 4
    byte b3;  // 1

    //这个地方是对象指针 在不开启Java压缩的状态下 默认byte 开启状态下默认4byte
    MemoryAligning[] obj;//0
    NullObject obj3 = new NullObject();//16


    //验证 对象在内存中排序会不会发生改变
    public void verificationSort() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        Field[] fields = MemoryAligning.class.getDeclaredFields();
        Comparator<Long> comparator = Long::compareTo;
        Map<Long, String> map = new TreeMap(comparator);
        //其实通过内存偏移量也可以看到 内存是如何补齐的
        for (Field f : fields) {
            //打印出属性在对象中的偏移量  数值越小 越接近对象初始位置
            System.out.println(f.getName() + " offset: " + unsafe.objectFieldOffset(f));
            map.put(unsafe.objectFieldOffset(f), f.getName());
        }
        map.forEach((k, v) -> {
            System.out.println(v + ":" + k);
        });
    }


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        MemoryAligning memoryAligning = new MemoryAligning();
        long objectSize = ObjectSizeCalculator.getObjectSize(memoryAligning);
        System.out.println(objectSize);
        memoryAligning.verificationSort();

        final ClassIntrospector ci = new ClassIntrospector();
        ObjectInfo res;

        res = ci.introspect(memoryAligning);
        System.out.println(res.getDeepSize());
    }
}

