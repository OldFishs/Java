package com.xxx.jdbc.preeparedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class preparedstatehomework {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the password:");
        String password = scanner.nextLine();

        //创建properties
        Properties properties = new Properties();
        //load
        properties.load(new FileInputStream("src\\mysql.properties"));

        //列数据
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //
        //注册驱动
        Class.forName(driver);

        //连接
        Connection connection = DriverManager.getConnection(url,user,pwd);

        //sql语句
        String sql = "insert into preparedstatement values(?,?)";

        //使用preparestatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.executeUpdate();

        connection.close();
        preparedStatement.close();
    }
}
