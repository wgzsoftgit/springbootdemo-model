package com.demomodel.utils.demo.equests;

public class TestString2 {
/**
 * == 比较的是地址
 * equest 比较的是内容
 * @param args
 */
	public static void main(String[] args) {

		String s1 = "Monday";

		String s2 = new String("Monday");

		if (s1 == s2) {

			System.out.println("s1 == s2");

		} else {

			System.out.println("s1 != s2");
		}

		if (s1.equals(s2)) {

			System.out.println("s1 equals s2");

		} else {

			System.out.println("s1 not equals s2");
		}

	}

}