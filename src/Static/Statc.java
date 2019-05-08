package Static;

//public static class Statc {  说明 static 不可以修饰 类
public  class Statc {
    public static int v=1;

    private static  String a= bbb();
    //如果bbb不是静态(static)变量  那么 这个引用 将报错，因为 a为静态变量；静态变量初始化值一定要是静态变量 或基本类型
    public static String bbb(){
        System.out.println("bbb被执行");
        return  "aaa";
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    //In
    static int iwrap=new Integer(v); //
    public static void main(String[] args) {
        Statc e=new Statc();
        {  //这三个 给v赋值的方法 效果是一样的
            v = 3;
            Statc.v = 3;  //这样可以给v改值为3
            e.v++;  //这样 的效果与上面方法的效果相同
        }
        System.out.println(v);
        e.setA("a");
        //先初始化 再被赋值
        System.out.println(e.getA());
        //int可以被Integer包装，也可以被int接收
        System.out.println(iwrap); //之所以输出1 是因为 iwrap的值 在程序 编译期就确定了  不收后来改值影响
    	}

}
