package String;


import java.util.Date;

public class format {

    public static void main(String[] args) {
        Date data=new Date();
        String a=String.format("%tA,%<tB %<td",data);
        System.out.println(a);
    }

}
