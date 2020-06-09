package com.demomodel.configure.doubledatasource.textdoubledatasource.master.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.demomodel.configure.doubledatasource.textdoubledatasource.master.map.DemotxtMapper;

@Service
//@Transactional(propagation= Propagation.REQUIRED,rollbackFor = Exception.class)
public class DemotxtServiceImpl implements DemotxtService {

	@Autowired
	DemotxtMapper demotxtMapper;
	DemotxtServiceImpl2 demotxtServiceImpl2=new DemotxtServiceImpl2();
	@Transactional(propagation= Propagation.REQUIRED,rollbackFor = Exception.class)
	@Override
	public String textTransaction() {	
		//假设这是一个service类的片段
		try{
			demotxtMapper.insert();
		    //出现异常  就回滚操作
			//int a=1/0;
		} catch (Exception e) {
		            e.printStackTrace();
		           //设置手动回滚    手动回滚，推荐方式
		            TransactionAspectSupport.currentTransactionStatus()
		                    .setRollbackOnly();
		            return  "err";   
		        }
		//此时return语句能够执行
		return  "ok";
	}
/**
 * Connection is read-only. Queries leading to data modification are not allowed
 * 连接是只读的。不允许导致数据修改的查询
 * 报错
 */
	@Transactional(readOnly = true)  //设置为true表示只读，false则表示可读写，默认值为false
	@Override
	public String onlyread() {
		demotxtMapper.insert();
		return "ok";
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String insertB() {
		demotxtMapper.insert2();
		int a=1/0;  //a正常   b异常       a调用b     结果是两个插入都失败 都进行回滚
		return "ok";
	}
	//rollbackFor = Exception.class
	@Transactional()
	public String insertA() {
		demotxtMapper.insert();	
		this.insertB();
		return "ok";
	}
	//rollbackFor = Exception.class
	@Transactional()
	public String insertA1() {
		demotxtMapper.insert();	
		int a=1/0; 
		demotxtServiceImpl2.insertB();
		return "ok";
	}
	

}
