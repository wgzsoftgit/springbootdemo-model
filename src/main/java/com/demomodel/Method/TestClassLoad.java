package com.demomodel.Method;

import java.lang.reflect.Method;

public class TestClassLoad {
	public static void main(String[] args) throws Exception {
		/*Class<?> clz = Class.forName("A");
		Object o = clz.newInstance();
		Method m = clz.getMethod("foo", String.class);
		for (int i = 0; i < 16; i++) {
			m.invoke(o, Integer.toString(i));
		}*/
		
		Method m = A.class.getMethod("foo", String.class);
		Object o = A.class.newInstance();
		m.invoke(o, "张三");
	}
}