package com.xxx.jdbc.preeparedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

//演示preparedstatement及dml语句使用
public class preparedstatement {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //输入信息
        System.out.print("请输入姓名：");
        String name = scanner.nextLine();
//        System.out.print("请输入密码：");
//        String pwd = scanner.nextLine();

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

        //组织sql
        //String sql = "select name,pwd from admin where name = ? and pwd = ?";

        //添加记录
        //String sql = "insert into admin values(?,?)";

        //修改
        //String sql = "update admin set pwd = ? where name = ?";

        //删除
        String sql = "delete from admin where name=?";
        //得到preparedstatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //给问号赋值
//        preparedStatement.setString(1, name);
//        preparedStatement.setString(2, pwd);

//        preparedStatement.setString(2, name);
//        preparedStatement.setString(1, pwd);
        preparedStatement.setString(1, name);

        //不要写sql
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if(resultSet.next()){
//            System.out.println("登录成功");
//        }else{
//            System.out.println("登录失败");
//        }

        //执行dml语句，使用exupdate
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "success" : "failure");



        //关闭
        //resultSet.close();

        preparedStatement.close();
        connection.close();

    }
}
