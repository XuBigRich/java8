package LgAndBgleguansuobeiguansuo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ConFactory.java
 * @Description TODO
 * @createTime 2019年04月02日 12:23:00
 */
public class ConFactory {
    public static Connection getcon() {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1:3306/leguanbeiguan?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
            con=DriverManager.getConnection(url,"root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    //关闭连接
    public static void close(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
