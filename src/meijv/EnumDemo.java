package meijv;

public class EnumDemo {
    public static void xu() {
        //单属性常用static final
      String a=  Meijv.TASK_ID;
        //多属性常用enum
        String b = (Meij.NOT_EXISTS.getMsg());
        //因为没有设置 构造方法 与get/set方法 所以 取不到枚举内的属性
        String c=Zhi.NOT_EXISTS.toString();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
        public static void main(String[] args){
            EnumDemo.xu();
           String name= EnumStudent.FALL.getName();
            System.out.println(name);
            EnumMethod.GZFF2.son();
            System.out.println( EnumMethod.GZFF1.sum(1));
    }

}