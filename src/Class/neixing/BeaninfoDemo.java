package Class.neixing;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/*
* 这个包是描述 内省的
* 内省通过判断 get方法  来确定  javabean的存在
* 原理：通过get 来判断 是否存在 这个属性
* 若不存在name  但又有getName()这个方法 则内省机制 确定 存在name 这个属性
* */
public class BeaninfoDemo {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
BeanInfo beaninfo = Introspector.getBeanInfo(Student.class);
        Student student=new Student();
        student.setName("许大富");
        student.setAge(21);
//获取属性描述器
        PropertyDescriptor propertys[] = beaninfo.getPropertyDescriptors();
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        for (PropertyDescriptor property : propertys) {
            String key = property.getName();
//            输出所有含get方法的变量名
//            System.out.println(key);

            // 过滤class属性
            if (!key.equals("class")) {
//                 得到property对应的getter方法
                Method getter = property.getReadMethod();
                System.out.println("1:"+getter);
                if (getter != null) {
                    //获取变量值
                    Object value = getter.invoke(student);
                    System.out.println("2:"+value);
                    if (null != value) {
                        map.put(key, value);
                    }
                }
            }
        }


//获取属性描述器有  getWriteMethod();找到setXxx方法
//                 getReadMethod();  找到getXxx方法

//        propertyDescriptor属性描述其中的getPropertyType() 方法是获取属性写入 setXX()参数类型的Class或者getXX 中返回值的Class值！
        //======================================================
//        Student st = new Student();
//        Method setmethod = p.getWriteMethod();
//        setmethod.invoke(st, "aa");    //方法的执行！
//        //======================================================
//        setmethod.invoke(Student);

    }
}
