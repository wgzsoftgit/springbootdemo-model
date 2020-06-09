package com.demomodel.configure.doubledatasource.transaction.transactiontext;

import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.configure.doubledatasource.textdoubledatasource.master.map.DemotxtMapper;
import com.demomodel.configure.doubledatasource.textdoubledatasource.master.service.DemotxtService;
import com.demomodel.configure.doubledatasource.transaction.TransactionUtil2;
import com.demomodel.utils.springcontextbeanutils.SpringContextUtil2;

@RestController
@RequestMapping("transationText")
public class TransationText {
	//事务测试

	 
//	 @Autowired    
//	 TransactionUtil2 transactionUtil2;    //失效了 
			 
//	@Autowired
//	DemotxtMapper demotxtMapper;  //失效了
	
		  
	private TransactionStatus transactionStatus = null;
////有异常回滚成功   ---测试ok
	@RequestMapping("transationText1")
	private String primaryDataSource() {
TransactionUtil2 transactionUtil2=SpringContextUtil2.getBean(TransactionUtil2.class);
DemotxtMapper demotxtMapper=SpringContextUtil2.getBean(DemotxtMapper.class);

		transactionStatus = transactionUtil2.begin();
       try {  
		  demotxtMapper.insert(); 
	//	  int a=1/0;
	 
       } catch (Exception e) {
           System.err.println("ERROR >>> 执行出现异常 即将进行回滚操作");
           transactionUtil2.rollback(transactionStatus);
           throw e;
      }
       transactionUtil2.commit(transactionStatus); 
		return "ok";
	}
	
	//有异常回滚成功   ---测试ok
	@RequestMapping("transationText2")
	private String primaryDataSource2() {
TransactionUtil2 transactionUtil2=SpringContextUtil2.getBean(TransactionUtil2.class);
DemotxtService demotxtMapper=SpringContextUtil2.getBean(DemotxtService.class);	     
		return demotxtMapper.textTransaction();
	}
	//测试只读 不能对数据库进行修改   
	@RequestMapping("transationText3")
	private String primaryDataSource3() {   
TransactionUtil2 transactionUtil2=SpringContextUtil2.getBean(TransactionUtil2.class);
DemotxtService demotxtMapper=SpringContextUtil2.getBean(DemotxtService.class);	     
		return demotxtMapper.onlyread();
	}
	//测试  同一个方法的嵌套异常
	@RequestMapping("transationText4")
	private String primaryDataSource4() {   
TransactionUtil2 transactionUtil2=SpringContextUtil2.getBean(TransactionUtil2.class);
DemotxtService demotxtMapper=SpringContextUtil2.getBean(DemotxtService.class);	     
		return demotxtMapper.insertA();
	}
	
	@RequestMapping("transationText5")
	private String primaryDataSource5() {   
TransactionUtil2 transactionUtil2=SpringContextUtil2.getBean(TransactionUtil2.class);
DemotxtService demotxtMapper=SpringContextUtil2.getBean(DemotxtService.class);	     
		return demotxtMapper.insertA1();
	}
}
