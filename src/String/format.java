package String;


import java.util.Date;
/*
*
* */
public class format {

    public static void main(String[] args) {
        Date data=new Date();
        String a=String.format("%tA,%<tB %<td",data);
        System.out.println(a);
        String str=null;
        str=String.format("Hi,%s", "王力");
        System.out.println(str);
        str=String.format("Hi,%s:%s.%s", "王南","王力","王张");
        System.out.println(str);
    }

}
