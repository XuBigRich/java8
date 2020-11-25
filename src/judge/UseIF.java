package judge;

/**
 * 对判断的使用，与同类型 变量声明与赋值问题
 * @Author： hongzhi.xu
 * @Date: 2020/11/20 上午10:32
 * @Version 1.0
 */
public class UseIF {
    public void ifElseIf(){
        int a=1 , b=1;
        if(a>0){
            System.out.println("进入了if a判断");
        }else if(b>0){
            System.out.println("进入了else if b判断");
        }
        System.out.println("事实证明if判断只会进入一次，如果if成立那么else if 则不会进行判断");
    }

    public static void main(String[] args) {
        UseIF useIF=new UseIF();
        useIF.ifElseIf();
    }
}
