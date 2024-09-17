package com.xxx.jdbc.transaction;

import com.xxx.jdbc.utils.jdbcutils;
import org.junit.Test;

import java.sql.*;

//演示jdbc中使用事物
public class transaction {

    @Test
    public void testDML(){
        //得到连接
        Connection connection = null;

        //组织sql
        String sql1 = "update account set money = money - 100 where id = 1";
        String sql2 = "update account set money = money + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //创建preparedStatement
        try {
            connection = jdbcutils.getConnection();//默认情况下自动提交
            //设定不自动提交
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();//执行第一条

//            int i =1/0;

            PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
            preparedStatement1.executeUpdate();//执行第二条

            //提交事物
            connection.commit();
        } catch (SQLException e) {
            //设定回滚 默认回到事物开始阶段
            System.out.println("回滚开启，，，");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            jdbcutils.close(connection,preparedStatement,null);
        }
    }

}
