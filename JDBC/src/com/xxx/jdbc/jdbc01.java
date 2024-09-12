package com.xxx.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc01 {
    public static void main(String[] args) throws SQLException {
        //注册驱动
        com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();

        //得到连接
        String url = "jdbc:mysql://localhost:3306/xxx_db2";


        //将用户名 密码放入properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);

        //执行sql
        String sql = "insert into actor values(null,'周星驰','男','1988-11-11','123456789')";

        Statement statement = connect.createStatement();

        int i = statement.executeUpdate(sql);
        System.out.println(i>0 ? "成功":"失败");


        //关闭资源
        statement.close();
        connect.close();
    }
}
