package classDemo.nimingneibuClass;
/*
*    匿名内部类 关于接口 的两种调用方法
*    new什么接口 就去在后面直接实现这个接口的抽象类 就可以 建立 匿名类
* */
public class InterfaceDemo {
    //    1）
    public void fun(Person2 person2){
        System.out.println("匿名内部类");
        System.out.println(person2.eat());
    }
    public static void main(String[] args) {

        //    1）
        InterfaceDemo interfaceDemo =new InterfaceDemo();
        /*
         *  new Person2() {
                @Override
                public String eat() {
                    return "eat fxb";
                }
            }
        * 其作用是成对象
        * ==========================================
        * 生成的是下面这个类的对象  （因为是匿名类，所以没有类名）
        *（这个地方是空的因为是匿名类） {
                                            @Override
                                            public String eat() {
                                                return "eat fxb";
                                            }
                                        }
        * */
        interfaceDemo.fun(new Person2() {
            @Override
            public String eat() {
                return "eat fxb";
            }
            public String move(){
                return "走";
            }
        });
        Person2 p = new Person2() {
            public String eat() {
                return "eat something";
            }

            @Override
            public String move() {
                return "跑";
            }
        };
       String eat= p.eat();
       String move=p.move();
        System.out.println(eat);
        System.out.println(move);
    }

}
interface Person2 {
    String eat();
    String move();
}
