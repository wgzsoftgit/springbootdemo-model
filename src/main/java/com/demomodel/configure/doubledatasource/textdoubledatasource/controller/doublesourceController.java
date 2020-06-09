package com.demomodel.configure.doubledatasource.textdoubledatasource.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.configure.doubledatasource.textdoubledatasource.aop.xianliu.MyResult;
import com.demomodel.configure.doubledatasource.textdoubledatasource.aop.xianliu.RateLimit;
import com.demomodel.configure.doubledatasource.textdoubledatasource.master.dao.Demotxt;
import com.demomodel.configure.doubledatasource.textdoubledatasource.master.map.DemotxtMapper;
import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.dao.Usertimes;
import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.map.UsertimesMapper;
import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.service.UsertimesService;
import com.demomodel.utils.springcontextbeanutils.SpringContextUtil2;

@RestController
@RequestMapping("doublesourcetxt")
public class doublesourceController{

	
	@Autowired
	DemotxtMapper demotxtMapper;  //不知道为啥失效
	//@Autowired 替换方案     换一种方式
//	DemotxtMapper demotxtMapper=SpringContextUtil2.getBean(DemotxtMapper.class);

	@Autowired
	UsertimesService usertimesMapper;
	
 

	    @RequestMapping("primaryDataSourcetxt")
		private List<Demotxt> primaryDataSource() {
	   	DemotxtMapper demotxtMapper=SpringContextUtil2.getBean(DemotxtMapper.class);
	     	List<Demotxt>  list =demotxtMapper.selectALL(); 
	
			return list;
		}
	
	
	
	
	
	@RequestMapping("otherDataSourcetxt")
	private List<Usertimes> otherDataSource() {
		UsertimesMapper usertimesMapper2=SpringContextUtil2.getBean(UsertimesMapper.class);

	List<Usertimes>	 list =usertimesMapper2.selectALL();
	return list;   
	}
	
	// 漏桶算法  用于限流测试  
	//2个接口设定没秒限流5个和美妙限流10个 
	@RequestMapping("otherDataSourcetxt2")
    @RateLimit(limitNum = 5.0)
    public MyResult getResultsone() {
        System.out.println("调用了方法getResults");
        return MyResult.OK("调用了方法", null);
    }
	@RequestMapping("otherDataSourcetxt3")
    @RateLimit(limitNum = 10.0)
    public MyResult getResultTwo() {
        System.err.println("调用了方法getResultTwo");
        return MyResult.OK("调用了方法getResultTwo", null);
   }
//：https://blog.csdn.net/qq_39816039/java/article/details/83988517
}
