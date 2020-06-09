package com.demomodel.mysqlcontroller.initConnectionmysql.insertUPdata;

import java.sql.Connection;
import java.sql.DriverManager;
//只是他没用数据库连接池。是直接连接的
public class DBConnection {
 
    String driver = "com.mysql.jdbc.Driver";
    String url= "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "123456";
    
    public Connection conn;
 
    public DBConnection() {
 
        try {
            Class.forName(driver);// 加载驱动程序
            conn = (Connection) DriverManager.getConnection(url, user, password);// 连续数据库
            
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//https://blog.csdn.net/qq_33356083/java/article/details/80300311