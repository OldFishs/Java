package com.xxx.jdbc.datasource;

import com.xxx.jdbc.actor;
import com.xxx.jdbc.actor;
import com.xxx.jdbc.utils.jdbcutils;
import jdk.jfr.Timestamp;
import org.junit.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.commons.annotation.Testable;

import java.sql.*;
import java.util.ArrayList;

public class JDBCutilbydruid_use {
    @Test
    public void testDML(){
        //得到连接
        Connection connection = null;

        //组织sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //创建preparedStatement
        try {
            connection = JDBCutilnydruid.getDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);

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
            JDBCutilnydruid.close(connection,preparedStatement,resultSet);
        }
    }

    //土方法解决封装
    @Test
    public void testlecttoarraylist(){
        //得到连接
        Connection connection = null;

        //组织sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<actor> list = new ArrayList();
        //创建preparedStatement
        try {
            connection = JDBCutilnydruid.getDataSource();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);

            resultSet = preparedStatement.executeQuery();
            //遍历
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                //把得到的记录封装到actor对象放入list集合
                list.add(new actor(id,name,sex,borndate,phone));


            }
            for(actor actor : list){
                System.out.println(actor);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源
            JDBCutilnydruid.close(connection,preparedStatement,resultSet);
        }

    }
}
