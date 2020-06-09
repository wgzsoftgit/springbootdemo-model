package com.demomodel.utils.readpropersion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Properties;
/**
 * 
 * 读取properties属性文件
 *  生成properties属性文件
 * @author zbj
 *
 */
public class testGetProperties {

	public static void main(String[] args) throws IOException {
		writpro(); //文件写入内容  /resurce文件下
		System.err.println(readSecret());
		readProperties();
		//readProperties2();
		writeProperties();
		
	}

	/**
	 * 读取properties属性文件
	 */
	public static void readProperties() throws IOException {

		Properties prop = new Properties();

		InputStream inStream = testGetProperties.class.getClassLoader().getResourceAsStream("token.properties");

		/*
		 * FileInputStream inputFile=new
		 * FileInputStream("classpath:config/server.properties");
		 */
		prop.load(inStream);
		prop.setProperty("port", "3307");//内存中修改值
		Iterator<String> it = prop.stringPropertyNames().iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + ":" + prop.getProperty(key));

		}

		System.out.println("反射"+prop.getProperty("port"));

		inStream.close();
	}

	/**
	 * 读取properties属性文件 成功
	 */
	public static void readProperties2() throws IOException {

		Properties prop = new Properties();

		 InputStream inStream =
		 testGetProperties.class.getClassLoader().getResourceAsStream("token.properties");

		
		//  FileInputStream inputFile=new FileInputStream("D:/token.properties");//需要具体的名字
		 
	   prop.load(inStream);
		Iterator<String> it = prop.stringPropertyNames().iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key + ":" + prop.getProperty(key));
		}
		inStream.close();
	}
	
	/**
	 * 生成properties属性文件  成功
	 */
	public static void writeProperties() {

		Properties prop = new Properties();
		try {
			FileOutputStream oFile = new FileOutputStream(new File("D://sys-config.properties"), true);
			prop.setProperty("driver-name", "oracle.jdbc.driver.OracleDriver");
			prop.setProperty("url", "jdbc：oracle:thin:@localhost:1521:ORCL");
			prop.setProperty("user-name", "drp1");
			prop.setProperty("password", "drp1");
			prop.store(oFile, "sys-config");
			oFile.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	/**
     * 读取密钥  成功
     * @return 密钥信息
     */
    private static String readSecret() {
        Properties properties = new Properties();
        //加载resource目录下的配置文件   jwtsecret.properties
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("token.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
           System.err.println("读取密钥文件错误");
        }
        return properties.getProperty("token");
    }
    
	/**
	 * 写文件  成功
	 */
public static void writpro() {
	Properties pro=new Properties();
	pro.setProperty("token","wgz2345622323");
	try {
		File file=new File("src/main/resources/token.properties");
		OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(file));
		pro.store(writer,"setToken");
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}