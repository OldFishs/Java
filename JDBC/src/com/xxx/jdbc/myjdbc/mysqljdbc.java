package com.xxx.jdbc.myjdbc;

public class mysqljdbc implements jdbcinterface {
    @Override
    public Object getconnect() {
        System.out.println("Connecting to MySQL");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("finish connecting to MySQL");
    }

    @Override
    public void close() {
        System.out.println("close MySQL");

    }
}
