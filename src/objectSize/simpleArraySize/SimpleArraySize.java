package objectSize.simpleArraySize;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import objectSize.ObjectArraySize.NullObject;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * -XX:-UseCompressedOops
 * 这个类只用于描述数组大小
 * <p>
 * 在开启了指针压缩的前提下 对象默认大小12byte
 * <p>
 * public int i[]
 * 数组引用占4个字节
 * 12(_mark+oop) + 4(i 引用)=16
 * 占用 16字节
 * <p>
 * public int i[] = new int[0];
 * 数组引用占4个字节
 * 数组长度描述大小占4个字节（可以说明数组不可以大于 一个字节 =8bit ，四个字节=32bit ，数组不可以大于 4294967295 个bit 但是由于 符号位 实际只能使用2147483647，具体还需要jvm去设置）
 * _mark 占 8字节、 _oop 占8字节
 * 12(_mark+oop) + 4(i 引用) +8（byte : _mark） + 4(byte : _oop) +4(数组描述长度)  = 32
 * 数组 [num] num 每增加1扩容 int实际类型大小个数，因为他存储的是实际值
 * 具体可使用   public byte i[] = new byte[0]; 与public int i[] = new int[0]; 交替 验证
 * 所以 public int i[] = new int[0] 占 32字节
 * <p>
 * <p>
 * NullObject[] nullObjects = new NullObject[0];
 * 12(_mark+oop) + 4(nullObjects 引用) +8（byte : _mark） + 4(byte : _oop) +4(数组描述长度)  = 32
 * 且数组 [num] num 每增加1 就多一套 NullObject的引用 引用大小为4（因为他存储对象）
 * <p>
 * 剩下的看objectArraySize
 *
 * @author 许鸿志
 * @since 2021/9/3
 */
public class SimpleArraySize {
    //0每次加1 多一个字节
//    public int i[] = new int[0];
//     public byte i[] = new byte[0];
    public NullObject[] nullObjects = new NullObject[0];


    public static void offset() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        Field[] fields = SimpleArraySize.class.getDeclaredFields();
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

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        SimpleArraySize simpleArraySize = new SimpleArraySize();
        long objectSize = ObjectSizeCalculator.getObjectSize(simpleArraySize);
        System.out.println(objectSize);
        //通过偏移量辅助查看
        offset();
    }
}
