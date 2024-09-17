package com.xxx.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//基于druid的数据库连接池的工具类
//把引用连接放回连接池
public class JDBCutilnydruid {

    private static DataSource ds;

    static{
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src\\druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //编写getconnection方法
    public static Connection getDataSource() throws SQLException {
        return ds.getConnection();
    }

    //关闭连接
    //在数据库连接池中close不是真的断掉连接，而是把connect放回连接池、
    public static void close(Connection conn, Statement stmt, ResultSet rs) {

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
