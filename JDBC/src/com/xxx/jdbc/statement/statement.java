package com.xxx.jdbc.statement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class statement {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);

        //输入信息
        System.out.print("请输入姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入密码：");
        String pwd = scanner.nextLine();

        //p获取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        //获取相关值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //注册驱动
        Class.forName(driver);

        //连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //得到statement
        Statement statement = connection.createStatement();

        //组织sql
        String sql = "select name,pwd from admin where name = '" + name + "' " +
                "and pwd = '" + pwd + "'";

        //查询用exquery
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        //关闭
        resultSet.close();
        statement.close();
        connection.close();
    }
}
