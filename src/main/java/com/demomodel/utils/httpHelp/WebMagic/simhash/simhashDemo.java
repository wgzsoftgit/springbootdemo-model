package com.demomodel.utils.httpHelp.WebMagic.simhash;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;



public class simhashDemo {
public static void main(String[] args) throws IOException {
	String str1=readAllFile("D:\\text\\result\\text");
	System.err.println();
	
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
