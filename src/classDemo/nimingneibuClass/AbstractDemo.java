package classDemo.nimingneibuClass;

public class AbstractDemo {
   public static void main(String[] args) {
   		Person p=new Person() {
            @Override
            public void eat() {
                System.out.println("eat sometion");
            }
        };
   		p.eat();
   	}

}
abstract class Person{
    public abstract void eat();
}