package clone.kaobei;
//浅拷贝：对基本数据类型进行值传递，对引用数据类型进行引用传递般的拷贝，此为浅拷贝。
//深拷贝：对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容，此为深拷贝。
/*
*深拷贝:
*相当于创建了一个新的对象，只是这个对象的所有内容，都和被拷贝的对象一模一样而已，即两者的修改是隔离的，相互之间没有影响
*浅拷贝:
*也是创建了一个对象，但是这个对象的某些内容（比如A）依然是被拷贝对象的，即通过这两个对象中任意一个修改A，两个对象的A都会受到影响
* */
//基本类型包括：int, Integer, long, Long, char, Charset, byte,Byte, boolean, Boolean, float,Float, double, Double, String
public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Boss Boss=new Boss();
        Boss.setName("许鸿志");
        Boss.setAge(21);

        Staff staff=new Staff();
        staff.setName("许家印");
        staff.setAge(60);
        staff.setBoss(Boss);
        System.out.println("复制前的：staff = "+staff);

        Staff staff1 = (Staff) staff.clone();
        staff1.setName("马云");
        staff1.setAge(50);
        Boss Boss1 = staff1.getBoss();
        Boss1.setName("许大富");
        Boss1.setAge(45);
         System.out.println("复制后的：staff = " + staff);
        System.out.println("之所以出现 被克隆后 原值被变更问题 是因为：对于浅拷贝 去拷贝类的实例对象 拷贝的其实是 实例对象的引用，更改Boss其实 就是更改的他的原属性。");
        System.out.println("相反:更改 他的 name,和age属性 却没有影响到他的原属性。 是因为：深拷贝 对于基本数据类型 的拷贝，是 值的拷贝。直接更改 仅仅是更改的 新对象的 name和age属性");
         System.out.println("复制后的：staff1 = " + staff1);
         Staff staff2=(Staff)staff.clone();
        Boss boss=new Boss();
        boss.setAge(51);
        boss.setName("啊啊啊");
        staff2.setBoss(boss);
        System.out.println("复制后的：staff = " + staff);
        System.out.println("复制后的：staff2 = " + staff2);
        //这次结果之所以没有替换掉 原来的 staff的 值 是因为 新建的 boss对象 替换掉了 原来 复制过来的 boss对象
        int a= staff1.hashCode();
        int b= staff.hashCode();
        System.out.println(a);
        System.out.println(b);
    	}
}
