package com.xxx.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//演示c3p0的使用
public class c3p0 {
    //方式一：相关参数 ，指定user url password
    @Test
    public void testc3p0_01() throws IOException, PropertyVetoException, SQLException {

        //1创建数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        //通过配置文件获取相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        //读取
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        //给数据源设置相关参数
        //管理连接由combopooleddatasource来管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //设置初始连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);

        //测试连接池效率
        long l = System.currentTimeMillis();
        for(int i = 0; i<4000;i++){
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        System.out.println("连接ok");
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }


    //第二种方式使用配置文件模板
    //将c3p0指定的xml拷贝到src目录下
    //该文件指定了相关参数
    @Test
    public void testc3p0_02() throws IOException, PropertyVetoException, SQLException {
        //完成set设置
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("xxx_db2");

        //测试5000次
        long l = System.currentTimeMillis();
        for(int i = 0; i<500000;i++){
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }

        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }
}
