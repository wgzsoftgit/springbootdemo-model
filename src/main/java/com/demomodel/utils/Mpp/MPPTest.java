package com.demomodel.utils.Mpp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;
 
 /**
  * mpp的连接配置
  * @author wgz
  * @date 创建时间：2020年7月10日 下午5:34:41
  * dependency>
          <groupId>com.pivotal</groupId>
          <artifactId>greenplum-jdbc</artifactId>
          <version>5.1.4</version>
          <scope>system</scope>
          <systemPath>${basedir}/lib/greenplum-jdbc-5.1.4.jar</systemPath><!--项目根目录下的lib文件夹下-->
  */
public class MPPTest {
    // JDBC连接串
        static String url = "jdbc:pivotal:greenplum://127.0.0.1:5432;DatabaseName=dcdb";
        // mpp用户名
        static String user = "mpp";
        // mpp密码
        static String passwd = "h3c";
 
        public static void main(String args[]) {
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;
            try {
                Class.forName("com.pivotal.jdbc.GreenplumDriver");//
                // 创建连接
                BasicDataSource ds = new BasicDataSource();
                ds.setUrl(url);
                ds.setUsername(user);
                ds.setPassword(passwd);
                conn = ds.getConnection();
                System.out.println("MPP连接成功！");
                st = conn.createStatement();
                //创建库
                st.execute("create database if not exists test;");
                System.out.println("创建数据库成功！");
                //使用库
                st.execute("use test;");
                System.out.println("使用数据库成功！");
                //创建表
                st.execute("create table if not exists test (id int,name varchar(20),age int);");
                System.out.println("创建表成功！");
                //插入数据
                st.execute("insert into test values(1,'test',15)");
                System.out.println("插入数据成功！");
                // 查询TEST表内容
                rs = st.executeQuery("SELECT * FROM test");
                System.out.println("查询数据成功，等待反馈结果！");
                while (rs.next()) {
                    System.out.print(rs.getString(1));
                    System.out.print("  ");
                    System.out.println(rs.getString(2));
                }
                rs.close();
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 关闭连接
                if (conn != null) {
                    try {
                        conn.close();
                        conn = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
