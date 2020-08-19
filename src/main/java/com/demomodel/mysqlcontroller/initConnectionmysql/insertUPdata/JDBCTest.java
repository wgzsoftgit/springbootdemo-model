package com.demomodel.mysqlcontroller.initConnectionmysql.insertUPdata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class JDBCTest {
 
    public static void main(String[] args){
        //add(uname, uemail, upwd);
        //update("李诗诗","lishishi@com","666");
        //show();
        del("王小五");
    }
    //插入操作
    public static int add(String uname,String uemail,String upwd) {
        int i=0;
        String sql="insert into employee (name,email,pwd) values (?,?,?)";
        DBConnection db = new DBConnection();
        try {
        	//PreparedStatement对象可以防止sql注入
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
            preStmt.setString(1, uname);
            preStmt.setString(2, uemail);
            preStmt.setString(3, upwd);
            preStmt.executeUpdate();
            //Statement statement = (Statement) db.conn.createStatement();
            //statement.executeUpdate(sql);
            
            preStmt.close();
            db.close();//关闭连接 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }
    //查找操作
    public static void show(){
         String sql ="select * from employee";
         DBConnection db = new DBConnection();
         
         System.out.println("-----------------");
         System.out.println("姓名" +"\t"+ "邮箱" +"\t"+ "日期");
         System.out.println("-----------------");
         
         try {
        	 //会产生sql注入
            Statement stmt = (Statement) db.conn.createStatement();
            ResultSet rs = (ResultSet) ((java.sql.Statement) stmt).executeQuery(sql);
            while(rs.next()){
                String uname = rs.getString("name");
                String uemail = rs.getString("email");
                String uhiredate = rs.getString("hiredate");
                
//                int studentId = resultSet.getInt(1);//第一行的第一列数据，我们知道是id，也知道是int类型，
//                String studentName = resultSet.getString(2);//第二个数据对应name

                //可以将查找到的值写入类，然后返回相应的对象 
                //这里 先用输出的端口显示一下
                System.out.println(uname +"\t"+ uemail +"\t"+ uhiredate);
            }
            rs.close();
            db.close();//关闭连接 
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    //更新操作
    public static int update(String uname,String uemail,String upwd) {
        int i =0;
        String sql="update employee set email=?,pwd=? where name=?";
        DBConnection db = new DBConnection();
        
        try {
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
            preStmt.setString(1, uemail);
            preStmt.setString(2, upwd);
            preStmt.setString(3, uname);
            preStmt.executeUpdate();
            
            preStmt.close();
            db.close();//关闭连接 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }
    //删除操作
    public static int del(String uname) {
        int i=0;
        String sql="delete from employee where name=?";
        DBConnection db = new DBConnection();
        try {    
        	
            PreparedStatement preStmt = (PreparedStatement) db.conn.prepareStatement(sql);
            preStmt.setString(1, uname);
            preStmt.executeUpdate();
            
            preStmt.close();
            db.close();//关闭连接 
        } catch (SQLException e){
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }
}
//：https://blog.csdn.net/qq_33356083/java/article/details/80300311