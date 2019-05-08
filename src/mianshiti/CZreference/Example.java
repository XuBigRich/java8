package mianshiti.CZreference;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName text.java
 * @Description 纯干货 每一个方法都不能删
 * @createTime 2019年03月25日 17:23:00
 */

/*
* 总结 ：传值 传的是reference
*        在方法中操作时，要注意是操作的原来的reference指向的对象 ，还是 新创建的对象
*        更改reference指向的对象的属性  还是 原来那个对象，直接更改reference的指向，再操作就与原来对象无关了
* */

public class Example {
    String str=new String("good");
    char[] ch={'a','b','c'};
    public static void main(String[] args) {
    		Example ex=new Example();
    		ex.str="1111";    //这个地方是直接更改，对象的str的reference指向 111  （改值）
    		ex.change(ex.str,ex.ch); //传递的是ex的对象，的str的reference  （这个reference指向的是字符串,区别于对象的属性str的值）
            System.out.println(ex.str+"and");
            System.out.println(ex.ch);

        ex.change(ex);  //传递的是对象的reference
        System.out.println("ex.str: "+ex.str);   //输出 的是 对象的str 引用
    	}
    public void change(String str,char ch[]){
        System.out.println(str);
        str="test ok";                          //str的reference由原来指向 111 改为 指向 test ok  （更改了指向）
        System.out.println("第一次输出str："+str);    //输出str
        ch[0]='g';                              //接收到ex.ch的reference，更改ch指向的数组，把ch[0]的指向改为g  （其实更改的 还是原来数组）
        ch= new char[]{'d', 'c'};               //区别于上边函数 ,这将改变ch 数组 指向 新数组。
    }
    public void change(Example example){   //接收reference（这个reference指向对象）
        System.out.println(str);
        example.str="39行输出";                   //操作reference所指的对象的str
        example=new Example();              //其exampl 的 reference不再指向 原来的 对象 而指向新对象   （更改了指向）
        example.str="41行输出";                   //再操作str 就与原来对象没有关系了
    }
}
