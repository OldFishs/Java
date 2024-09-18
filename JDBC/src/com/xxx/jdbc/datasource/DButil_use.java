package com.xxx.jdbc.datasource;

import com.xxx.jdbc.actor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DButil_use {
    //使用apache-dbutil工具类 + druid完成对表的crud操作

    @Test
    public void testquerymany() throws SQLException {

        //1 得到连接
        Connection connection = JDBCutilnydruid.getDataSource();

        //2使用DButil类和接口，引入相关jar包
        //3创建queryrunner
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id >= ?";

        //query执行sql语句得到resultset 封装到 arraylist集合中 返回集合
        //connection集合
        // sql执行的sql语句
        //new BeanHandler<>(Actor.class)  resultset --》Actor --》封装到arraylist
        //底层使用反射
        //1 就是给sql语句中？赋值
        //多行多列beanlisthander
        List<actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(actor.class),1);
        System.out.println("输出结果集的信息");
        for (actor actor : list) {
            System.out.println(actor);
        }
        JDBCutilnydruid.close(connection,null,null);

    }


    //返回单行记录
    @Test
    public void testquerysingle() throws SQLException {
        Connection connection = JDBCutilnydruid.getDataSource();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id = ?";
        //list去掉
        //单行beanhandler
        actor query = queryRunner.query(connection, sql, new BeanHandler<>(actor.class), 1);
        System.out.println(query);

        JDBCutilnydruid.close(connection,null,null);

    }

    //单列
    @Test
    public void testscalar() throws SQLException {
        Connection connection = JDBCutilnydruid.getDataSource();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id = ?";
        //单列scalarhandler
        Object query = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(query);
        JDBCutilnydruid.close(connection,null,null);

    }


    //演示dbutils 加druid完成dml操作（update insert delete）
    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCutilnydruid.getDataSource();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into actor values(null,)";

        int tommm = queryRunner.update(connection, sql, "tommm", 1);
        System.out.println(tommm);

        JDBCutilnydruid.close(connection,null,null);
    }
}
