package baozhuangbei;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IntegerDemo.java
 * @Description 包装类 可直接 被 基本类型 接收
 * @createTime 2019年04月23日 11:08:00
 */
public class BaozhuangDemo {
    public static void main(String[] args) {
        //以 int 与 Integer 为例   其他 包装类 原理 相似
        int a=new Integer(2);
        int b=2;
        Integer c=b;
    }
    /*
    *  基本类型 与 包装类
    *
    * boolean —> Boolean
      char —> Character
      byte—> Byte
      short—> Short
      long—> Long
      int —> Integer
      float—> Float
      double—> Double
    *
    *
    * */
}
