package com.xxx.jdbc.utils;

import com.xxx.jdbc.datasource.JDBCutilbydruid_use;
import com.xxx.jdbc.datasource.JDBCutilnydruid;
import org.junit.Test;

import java.sql.*;

//演示jdbcutils使用
public class jdbcutils_use {

    @Test
    public void testDML(){
        //得到连接
        Connection connection = null;

        //组织sql
        String sql = "select * from actor where id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //创建preparedStatement
        try {
            connection = JDBCutilnydruid.getDataSource();
            System.out.println(connection.getClass());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            //给问号赋值
//            preparedStatement.setString(1,"王宝强");
//            preparedStatement.setInt(2,1);
//            preparedStatement.executeUpdate();
            resultSet = preparedStatement.executeQuery();
            //遍历
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                System.out.println(id + "\t"+ name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            JDBCutilnydruid.close(connection,preparedStatement,null);
        }
    }
}
