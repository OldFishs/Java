package com.xxx.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class jdbcutils {

        //定义相关属性
        private static String user;
        private static String password;
        private static String url;
        private static String driver;

        //在static代码块初始化
        static {


            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("src\\mysql.properties"));

                //读取数据
                user = properties.getProperty("user");
                password = properties.getProperty("password");
                url = properties.getProperty("url");
                driver = properties.getProperty("driver");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //连接数据库，返回connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭资源
    public static void close(Connection conn, Statement stmt, ResultSet rs) {

            //判断是否为空
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
