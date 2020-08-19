package com.demomodel.mysqlcontroller.initConnectionmysql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 使用datasource方法建立mysql数据库连接。
 * @author bestree007;
 *
 */
public class MYSQLConnection {
	public static void main(String[] args) {
		BasicDataSource ds;
		Connection conn2;
		// create connection with a datasource object
		ds = new BasicDataSource();
		ds.setDriverClassName("");
		ds.setUrl("");
		ds.setUsername("localhost");
		ds.setPassword("bestree");
	
		//ds.setPort(3306);
		// ds.setURL("jdbc:mysql://localhost:3306/bestree");
		try {
			conn2 = ds.getConnection("bestree", "password");
			if (!conn2.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			Statement statement = conn2.createStatement();
			String sql = "select * from pet";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
			rs.close();
			conn2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}