/**
 * 
 */
package com.demomodel.utils.de.randomString;

import java.util.Random;

/**
 * @author shawnkuo
 * 
 */
public class CodeGenerator {

	public static String gencode(int len) {
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] characters = {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'f', 'g', 'h', 'i', 'j', 'k',
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'l', 'm', 'n', 'o', 'p', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'q', 'r', 's', 't', 'u', 'v', 'w','0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'x', 'y', 'z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < len) {
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
			if (i >= 0 && i < characters.length) {
				pwd.append(characters[i]);
				count++;
			}
		}
		return pwd.toString();
	}
	
	public static String genNumCode(int len) {
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] characters = {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < len) {
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
			if (i >= 0 && i < characters.length) {
				pwd.append(characters[i]);
				count++;
			}
		}
		return pwd.toString();
	}
	
	
	
	public static void main(String [] args) {
		System.out.println(gencode(10));
	}
}
