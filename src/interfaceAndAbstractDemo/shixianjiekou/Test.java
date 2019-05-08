package interfaceAndAbstractDemo.shixianjiekou;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
//    		Person person=new Teacher(); //会报错 因为Teacher类没有继承Persson接口
            Person person=new Student();
            Class c=Student.class;
            Person person1=(Student)c.newInstance();
            BeanInfo bean=Introspector.getBeanInfo(Student.class);
            PropertyDescriptor propertys[] = bean.getPropertyDescriptors();
            for(PropertyDescriptor property:propertys ){
                while (property.getName().equals("book")) {
                    Method method = property.getWriteMethod();
                    method.invoke(person1,"haha");
                    System.out.println("aaa");
                    break;
                }
            }
            person1.say();
            ((Student) person1).see();

    	}
}
