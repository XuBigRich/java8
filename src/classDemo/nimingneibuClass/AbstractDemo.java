package classDemo.nimingneibuClass;

import java.lang.reflect.InvocationTargetException;

public class AbstractDemo {
   public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       //这行代码 说明 匿名内部类 可以用于抽象 类  实现抽象方法
   		Person p=new Person() {
            @Override
            public void eat() {
                System.out.println("eat sometion");
            }
        };
   		p.eat();
   		// 这行代码 说明 匿名内部类 也可以用于 正常类  重写 方法  (注意不能重载方法)
       Animal animal=new Animal(){
           /*@Override
           public String say() {
               System.out.println("aaa");
               return "aaa";
           }*/
           public void aaa(){                     //匿名内部类 允许随意添加方法
               System.out.println("ccc");          //但是 不可随意调用 ,animal.aaa()  这样调用是 不正确的
           }                                        //但是可以通过反射的方式调用 这个方法
           @Override
           public void say() {
               System.out.println("aaa");
           }
       };
       animal.say();
       animal.getClass().getMethod("aaa",null).invoke(animal,null);  //反射方式调用 方法
   	}


}
abstract class Person{
    public abstract void eat();
    private void aaa(){}//这样写 虽然不会报错 但是子类 无法继承 相当于 一个死方法
}
class Animal{
    public void say(){
        System.out.println("说啥？");
    }
}
