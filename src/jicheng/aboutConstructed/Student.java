class Person{
	public String name;
	public int age=20;
	public Person(){
		System.out.println("Person输出");
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
		System.out.println(this.name);
		System.out.println(this.age);
	}
}
public class Student extends Person{
	public String sex;
	public Student(){

	}
	public Student(String sex){
		super("许鸿志",20);//super关键字 必须 放在构造函数的第一句，凡是实例子类  必定要 先实例 父类 ，若没有写父类构造函数 则默认调用 调用父类的无参构造函数
		this.sex=sex;
		System.out.println("Student输出"+super.name);
	}

	public static void main(String[] args) {
		// Student student=new Student("男");
		Student student=new Student();
		System.out.println("哈哈"+student.age);
	}
}