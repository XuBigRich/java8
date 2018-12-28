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
/*
 * 在计算机科学中，内省是指计算机程序在运行时（Run time）检查对象（Object）类型的一种能力，通常也可以称作运行时类型检查。
 *不应该将内省和反射混淆。相对于内省，反射更进一步，是指计算机程序在运行时（Run time）可以访问、检测和修改它本身状态或行为的一种能力。
 * */
public class BeaninfoDemo {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beaninfo = Introspector.getBeanInfo(Student.class); //通过 Introspector来获取某个对象的BeanInfo信息
        Student student=new Student();
        student.setName("许大富");
        student.setAge(21);
//获取属性描述器
        PropertyDescriptor propertys[] = beaninfo.getPropertyDescriptors();//通过beanInfo的属性描述器 得到的属性描述器 可以的到某个属性对应的getter/setter方法
        Map<String, Object> map = new ConcurrentHashMap<String, Object>();
        for (PropertyDescriptor property : propertys) {
          //Method set=  property.getWriteMethod();
          // String setNmae=set.getName(); //这个地方会报空指针  因为 属性描述器通过get方法判断出存在伪造的abc属性（其实不存在）  然后从过abc去找set方法 但是没有伪造abc的set方法所以 获取不到set方法所以 报空指针
            Method get = property.getReadMethod();
            Method set=property.getWriteMethod();
            if(property.getName().equals("age")) {  //先判断 如果 属性的名字为age
                set.invoke(student,1);  //使用set方法  让 student 变量所 指向的 对象 使用，  设置 参数 为1
                System.out.println(student.getAge());
            }
            System.out.println("=========================");
            String getNmae = get.getName();
            System.out.println(getNmae);//输出 所有get方法的方法名
            String key = property.getName();
            System.out.println(key);// 输出所有的属性（通过判断是否含有get方法来确定这个属性   （因为是通过get方法确定 所以会有判断出错的时候详情看student类））
/*
            // 过滤class属性 ，因为 每一个 类 都有一个 隐藏的 class属性
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
            }*/
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
