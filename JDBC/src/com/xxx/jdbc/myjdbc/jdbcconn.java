package com.xxx.jdbc.myjdbc;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcconn {
    //方式一
    @Test
    public void connect() throws SQLException {
        //注册驱动
        com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();

        //得到连接
        String url = "jdbc:mysql://localhost:3306/xxx_db2";


        //将用户名 密码放入properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    //方式二
    @Test
    public void connect2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //使用反射加载，动态加载
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();

        //得到连接
        String url = "jdbc:mysql://localhost:3306/xxx_db2";


        //将用户名 密码放入properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");

        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    //方式三，用drivermanager 代替driver 统一管理 拓展性更好
    @Test
    public void connect3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //使用反射加载
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver  = (Driver) aClass.newInstance();

        //创建url user password
        String url = "jdbc:mysql://localhost:3306/xxx_db2";
        String username = "root";
        String password = "123456";

        //注册driver驱动
        DriverManager.registerDriver(driver);

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
    }

    //方式四
    //Class.forname自动注册驱动，简化代码, 开发中用最多
    //mysql5.1.6以后可以不写classforname
    //建议写上，更加明确
    @Test
    public void connect04() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //使用反射加载driver类
        //Class.forName("com.mysql.cj.jdbc.Driver");

        //创建url user password
        String url = "jdbc:mysql://localhost:3306/xxx_db2";
        String username = "root";
        String password = "123456";

        Connection connect = DriverManager.getConnection(url, username, password);
        System.out.println(connect);
    }

    //方式五 在四基础上优化
    @Test
    public void connect05() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
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
        System.out.println(connection);
    }

}
