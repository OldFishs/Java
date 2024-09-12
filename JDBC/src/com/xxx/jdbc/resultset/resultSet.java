package com.xxx.jdbc.resultset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//select 语句返回resultset 取出结果
public class resultSet {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //通过properties获取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        //获取相关值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        //得到statement
        Statement statement = connection.createStatement();

        //组织sql
        String sql = "select id,name,sex,borndate from actor";

        //执行给定的sql语句 返回单个resultset对象
        ResultSet resultSet = statement.executeQuery(sql);

        //使用while循环取出数据
        while (resultSet.next()) {//光标向后移动
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date birthdate = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + birthdate);
        }

        //关闭
        resultSet.close();
        statement.close();
        connection.close();


    }
}
