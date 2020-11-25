package switchDemo;
/*
*基本数据类型：byte, short, char, int

包装数据类型：Byte, Short, Character, Integer

枚举类型：Enum

字符串类型：String（Jdk 7+ 开始支持）
* */
//String 类型
public class SwitchDemo {
    public static void StringSwich(String swit){

        switch (swit){
            case "1":
                System.out.println("输入的是:1");
                break;
            case "2":
                System.out.println("输入的是:2");
        }
    }
    public static void IntegerSwitch(){
        Integer value = 5;
        switch (value) {
            case 3:
                System.out.println("3");
                break;
            case 5:
                System.out.println("5");
                break;
            default:
                System.out.println("default");
        }
    }

    public static void EnumSwitch(){
        Status status = Status.PROCESSING;
        switch (status) {
            case OPEN:
                System.out.println("open");
                break;
            case PROCESSING:
                System.out.println("processing");
                break;
            case CLOSE:
                System.out.println("close");
                break;
            default:
                System.out.println("default");
        }
    }

    /**
     * 在执行case过程中 对case值进行改变
     */
    public static void mianshi(){
        int i=1;
        switch (i) {
            case 1:
                i=i+2;
                System.out.println(i);
            case 3:
                i=i+2;
                System.out.println(i);
                break;
            case 5:
                System.out.println(i);
                break;
            default:
                System.out.println("default");
        }
    }

    /**
     * 验证default 会在都执行了 之后执行吗
     */
    public static void mianshi2(){
        int i=1;
        switch (i) {
            case 1:
                i=i+2;
                System.out.println(i);
            case 3:
                i=i+2;
                System.out.println(i);
            default:
                System.out.println("default");
        }
    }
    public static void main(String[] args) {
//    		SwitchDemo.StringSwich("1");
//        IntegerSwitch();
//        EnumSwitch();
        mianshi();
        mianshi2();
    	}
}
