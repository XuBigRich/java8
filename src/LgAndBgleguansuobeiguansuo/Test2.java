package LgAndBgleguansuobeiguansuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName test.java
 * @Description 乐观锁与悲观锁
 * @createTime 2019年04月02日 12:11:00
 */
public class Test2 {
    public static void main(String[] args) throws SQLException, InterruptedException {
        Test2 tests = new Test2();
        Thread[] threads = new Thread[100];
        for (int i=0;i<threads.length;i++){
            threads[i] = new Thread(){
                @Override
                public void run() {
                    try {
                        tests.service();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
        }
        for (int i=0;i<threads.length;i++){
            threads[i].start();
        }
    }
    public void service() throws Exception {
        Connection connection = ConFactory.getcon();
        String selectSql = "select count from stock where id = 1";
        PreparedStatement statement1 = connection.prepareStatement(selectSql);
        ResultSet resultSet = statement1.executeQuery();
        resultSet.next();
        String count = resultSet.getString("count");  //查询出库存
        System.out.println(count);
        int c = Integer.parseInt(count);
        Thread.sleep(10);
        if (c<1) throw new Exception();  //如果库存 小于1了 就代表 不够了
        String updateSql = "update stock set count = count - 1 where count > 0";
        PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
        int update = preparedStatement.executeUpdate();
        String insertSql = "insert into stock_order(sid,name) VALUES (1,'aaa')";
        PreparedStatement statement = connection.prepareStatement(insertSql);
        int insert = statement.executeUpdate();
    }

}
