package com.demomodel.utils.httpHelp.WebMagic.simhash;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;


/**
 * 读取文件内容
 * @author wgz
 * @date 创建时间：2020年9月14日 下午9:05:53
 */
public class simhashDemo {
public static void main(String[] args) throws IOException {
	String str1=readAllFile("D:\\text\\result\\text.txt");
	System.err.println(str1);
	
}

private static String readAllFile(String filename) throws IOException {
	String everything="";
	try {
		FileInputStream inputStream =new FileInputStream(filename);
		everything=IOUtils.toString(inputStream);
		inputStream.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return everything;
}
}
