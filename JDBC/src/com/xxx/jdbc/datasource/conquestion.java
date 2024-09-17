package com.xxx.jdbc.datasource;

import com.mysql.cj.jdbc.JdbcConnection;
import com.xxx.jdbc.utils.jdbcutils;
import org.junit.Test;

import java.sql.Connection;

public class conquestion {

    //连接mysql5000次
    @Test
    public void contest(){

        long l = System.currentTimeMillis();
        for(int i=1;i<=5000;i++){
            // 传统方法
            Connection connection = jdbcutils.getConnection();

            jdbcutils.close(connection,null,null);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-l);
    }
}
