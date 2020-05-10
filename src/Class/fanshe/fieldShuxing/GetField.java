package Class.fanshe.fieldShuxing;

import java.lang.reflect.Field;

/**
 * 获取属性的举例
 */
public class GetField {
    public int i=20;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        GetField getField=new GetField();
        Class c=getField.getClass();
        //获取属性为i的 “属性对象”
        Field i=c.getField("i");
        //从getField对象中取得值
        System.out.println(i.get(getField));
        //特别提醒 Field 的hashcode 不是getField上面的hashcode
    }
}
