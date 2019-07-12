package meijv;
/*如果想要在方法块中 必须要实现 这个类的所有抽象方法
如果不想实现可以弄一个方法给他重写也可以类似于57行代码
枚举 有点类似于选择 使用哪个方法去（实例/实现 变量/方法）
*/
public enum EnumMethod {
     /*测试 say*/
     GZFF1{
         public void say(){
             System.out.println("说");
         }


         @Override
         public int ride(int i) { 
             return i*2;
         }
     },
    /*测试 say*/
    GZFF2{
        public void say(){
            System.out.println("学");
        }

        @Override
        public int ride(int i) {
            return i*3;
        }
    };



    /**
     * 抽象方法，由不同的枚举值提供不同的实现。
     * 　　枚举类可以实现一个或多个接口。与普通类一样，实现接口的时候需要实现接口中定义的所有方法，
     * 那这个枚举类就是抽象的，只是不需显式加上abstract修饰，系统化会默认加上。
     */
    public abstract void say();
    /*这样写也不会错  不过调用枚举构造方法时候不会执行  只执行被重写的*/
   /* public  void say(){
        System.out.println("逗");
    };*/
   public void son(){
       System.out.println("唱");
   }
   public abstract int ride(int i) ;
   public int sum(int i){
       return ride(i+6);
   }

}
