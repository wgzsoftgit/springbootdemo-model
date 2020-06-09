package com.demomodel.utils.readpropersion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取  token.properties文件的内容
 * @author wgz
 * @date 创建时间：2020年5月26日 下午3:10:08
 */
public class Properity {

	public String getProp(String propName){
		InputStream in = getClass().getClassLoader().getResourceAsStream("token.properties");
		Properties props = new Properties();
		String prop = null;
		try{
			props.load(in);
			prop = props.getProperty(propName);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public static void main(String[] args) {
		Properity properity=new Properity();
		System.out.println(properity.getProp("token"));
	}
}
