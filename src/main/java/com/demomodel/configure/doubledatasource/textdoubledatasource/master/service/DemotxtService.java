package com.demomodel.configure.doubledatasource.textdoubledatasource.master.service;

public interface DemotxtService {

	
	String textTransaction();
	
	String onlyread();
	
	//测试嵌套事务
	String insertB();
	String insertA();
	
	String insertA1();
}
