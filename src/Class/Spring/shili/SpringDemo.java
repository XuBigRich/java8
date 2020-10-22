package Class.Spring.shili;

public class SpringDemo  {
    /*
    * 动态创建对象 只要是 自 这个接口 肯定 有这个对象的 方法；
    * 所以 就可以执行 ；
    * */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       String student= "Class.Spring.shili.Student";
       String techer= "Class.Spring.shili.Techer";
        Class aaa= Class.forName(student);
        System.out.println(aaa.getName());
        Person a= (Person)aaa.newInstance();
        a.say();
    	}
}
