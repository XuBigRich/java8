package LgAndBgleguansuobeiguansuo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Test1.java
 * @Description 乐观锁与悲观锁
 * @createTime 2019年04月02日 14:26:00
 */
public class Test1{
        public static void main(String[] args) {
            Test1 test = new Test1();
            Thread[] threads = new Thread[200];
            for (int i=0;i<200;i++){
                int finalI = i;
                threads[i] = new Thread(){
                    @Override
                    public void run() {
                        test.service();
                    }
                };
            }
            for (int i=0;i<200;i++){
                threads[i].start();
            }
        }
    public void service(){
        try {
            Connection connection = ConFactory.getcon();
            Stock stock1 = checkStock(connection);
            updateCountByOpti(connection,stock1);
            createOrder(connection);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void createOrder(Connection connection) throws SQLException {
        String insertSql = "insert into stock_order(sid,name) VALUES (1,'aaa')";
        PreparedStatement statement = connection.prepareStatement(insertSql);
        int insert = statement.executeUpdate();
    }
    private void updateCountByOpti(Connection connection,Stock stock) throws SQLException {
        String sql = "update stock set count = count -1,version = version + 1 where version = " + stock.getVersion();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int update = preparedStatement.executeUpdate();
        if (update==0)
            throw new RuntimeException("没抢到");
    }
    public Stock checkStock(Connection connection) throws SQLException {
        String sql = "select * from stock where id = 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Stock stock = null;
        if (resultSet.next()){
            stock = new Stock();
            stock.setId(resultSet.getInt("id"));
            stock.setName(resultSet.getString("name"));
            stock.setCount(resultSet.getInt("count"));
            stock.setSale(resultSet.getInt("sale"));
            stock.setVersion(resultSet.getInt("version"));
        }
        if (stock.getCount()<1)
            throw new RuntimeException("没有库存了");
        return stock;
    }

}
