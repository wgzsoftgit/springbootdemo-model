package com.demomodel.Method;

public class B<T> {

	private Class clazz;
	//二   使用有参构造赋值,强行要求子类手动使用有参赋值
	public B(Class clazz) {  //只提供一个有参构造,这样子类如果没有写有参构造,就会编译错误
		this.clazz=clazz;
	}
	//跟第二种方案很像,就是使用set方法赋值,
	public void setClazz(Class clazz) {
		this.clazz=clazz;
	}
}
