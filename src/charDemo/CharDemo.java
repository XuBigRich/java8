package charDemo;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CharDemo.java
 * @Description TODO
 * @createTime 2019年04月18日 20:08:00
 */
public class CharDemo {
    char a = 'a'; // char的 赋值 只能用  单引号
    //char b=' a' //空格也占用字节
    char c = ' '; //同样 char也可以储存一个 空格
    //char d='ad';  //char只能储存一个 字符 这样是2个多了
//    char e='许'; //char 可以储存一个 汉字

    public static void use() {
        //unicode 码中的 十进制表示
        char Int = 35768;
        System.out.println(Int);
        //unicode 码中的 16进制表示
        char unicode = '\u8bb8';
        System.out.println(unicode);
        //直接上中文
        char chinese = '许';
        System.out.println(chinese);
    }

    public static void main(String[] args) {
        CharDemo charDemo = new CharDemo();
        use();
    }
}
