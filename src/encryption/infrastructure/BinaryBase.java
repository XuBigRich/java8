package encryption.infrastructure;

/**
 *
 * Result
 *
 * ​ java.lang.Byte : -128
 *
 * Analysis
 *
 * ​ 基本数据类型byte的大小是1个字节（8位），127+1=128，128用二进制数表示是1000 0000。
 *
 * Java中的二进制都是采用补码形式存储：
 * 1
 * ​ ⑴一个数为正，则它的原码、反码、补码相同
 * ​ ⑵一个数为负，则符号位为1，其余各位是对原码取反，然后整个数加1
 *
 * ​ 在System.out.println调用时，JVM会自动将byte类型转换为int类型 符号位和 数值位不变，中间填充0
 *
 * 127 （0111 1111 ）（补码） +  1 （0000 0001）（补码）= 1000 0000  （128） （补码）
 * 补码 1000 0000  因为System.out.println会变为 int
 *  1000 0000 0000 0000 0000 0000 1000 0000（补码存储）
 * 1000 0000 （表示为-128，不能表示为-0，和12点与0点区别一样）
 *
 * 因此System.out.println(showType(i) + " : " + i);输出为-128，即1000 0000 0000 1000 0000(第一个符号位，1负0正)
 * @Author： hongzhi.xu
 * @Date: 2022/2/9 4:01 下午
 * @Version 1.0
 */
public class BinaryBase {
    public static String move(Integer num){
        System.out.println("下面 ==== 开始 ===== 移动");
        //获取num的补码 然后输出  负数补1 正数补 0，其目的是为了让byte描述数字与 int 描述数字一致
        System.out.println(Integer.toBinaryString(num));
        //将补码数字有符号左移动3位 ，移动后补0，
        System.out.println(Integer.toBinaryString(num<<3));
        //将补码数字有符号右移动3位 ，负数移动后补1，正数移动后补0
        System.out.println(Integer.toBinaryString(num>>3));
        //将补码数字有符号左移动2位 ，移动后补0，
        System.out.println(Integer.toBinaryString(num<<24));
        return null;
    }

    private static String showType(Object object) {
        String type = object.getClass().getTypeName();
        return type;
    }

    public static void main(String[] args) {
        //0111 1111
        byte i = 127;
        i += 1;
        //输出该数字在jvm中的存储形式 （补码形式）
        System.out.println(Integer.toBinaryString(i));
        System.out.println(showType(i) + " : " + i);

        System.out.println("移动负数");
        move(-2);
        System.out.println("移动正数");
        move(2);
    }


}
