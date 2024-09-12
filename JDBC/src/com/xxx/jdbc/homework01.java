package com.xxx.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class homework01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);

        //执行sql
        //String sql1 = "create table news(ename varchar(32) not null primary key,content varchar(32))";
        //String sql2 = "insert into news(ename,content) values('北京','周年庆')";
        String sql3 = "update news set content = '国庆节' where ename = '北京'";
        String sql4 = "delete from news where ename = '北京'";
        Statement statement = connection.createStatement();
        //statement.executeUpdate(sql1);
        //statement.executeUpdate(sql2);
        //int i = statement.executeUpdate(sql3);
        statement.executeUpdate(sql4);

        statement.close();
        connection.close();

    }
}
