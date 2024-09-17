package com.xxx.jdbc.datasource;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

//测试druid的使用

public class druid {

    @Test
    public void testdruid() throws Exception {
        //1加入jar包
        //2加入配置文件
        //3创建properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        //4创建指定参数的数据库连接池.  druid连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        long l = System.currentTimeMillis();
        for(int i =0 ; i < 500000 ; i++){
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }

}
