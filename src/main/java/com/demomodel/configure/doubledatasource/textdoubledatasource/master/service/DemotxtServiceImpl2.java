package com.demomodel.configure.doubledatasource.textdoubledatasource.master.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.demomodel.configure.doubledatasource.textdoubledatasource.master.map.DemotxtMapper;
import com.demomodel.utils.springcontextbeanutils.SpringContextUtil2;

@Service
//@Transactional(propagation= Propagation.REQUIRED,rollbackFor = Exception.class)
public class DemotxtServiceImpl2  {

	@Autowired
	DemotxtMapper demotxtMapper;
	
	
	//,rollbackFor = Exception.class
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String insertB() {
		DemotxtMapper demotxtMapper=SpringContextUtil2.getBean(DemotxtMapper.class);
		  try {
			  demotxtMapper.insert2();
				int a=1/0;  //a正常   b异常       a调用b     结果是两个插入都失败 都进行回滚
		} catch (Exception e) {
			 TransactionAspectSupport.currentTransactionStatus()
             .setRollbackOnly();
			e.printStackTrace();
		}
		//被try包裹的事务不会回滚
		return "ok";
	}
	//rollbackFor = Exception.class
	@Transactional()
	public String insertA() {
		demotxtMapper.insert();	
		this.insertB();
		return "ok";
	}

	
	
	

}
