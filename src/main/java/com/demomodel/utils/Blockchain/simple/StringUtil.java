package com.demomodel.utils.Blockchain.simple;
import java.security.MessageDigest;

import com.google.gson.GsonBuilder;

public class StringUtil {
	
	//Applies Sha256 to a string and returns the result. 
	//将Sha256应用于字符串并返回结果。   生成一个独一无二的hash值（数字签名）
	public static String applySha256(String input){
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
			//Applies sha256 to our input, 将sha256应用于我们的输入
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
	        
			StringBuffer hexString = new StringBuffer(); // 这将包含十六进制的哈希This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//Short hand helper to turn Object into a json 的速记助手
	/**
	 * string将对象转换为json字符串
	 * @param o
	 * @return
	 */
	public static String getJson(Object o) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(o);
	}
	
	//返回难度字符串目标，以与哈希进行比较。例如难度5将返回“00000”
	//Returns difficulty string target, to compare to hash. eg difficulty of 5 will return "00000"  
	public static String getDificultyString(int difficulty) {
		return new String(new char[difficulty]).replace('\0', '0');
	}
	
	
}