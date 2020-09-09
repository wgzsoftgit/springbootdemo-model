package com.demomodel.query.threadPool.CallableFuture.demo2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.demomodel.bean.table.User2;

@Service
@Component
@EnableScheduling
public class TraffickingNarcoticsServiceImpl  {

	
	
	@Scheduled(cron = "0 43 20 * * ?")
	public void upDataGetRoomAndOppositeSexPoints2() throws InterruptedException {
		System.err.println("com.demomodel.query.threadPool.CallableFuture.demo2.TraffickingNarcoticsServiceImpl开始存入");
		
		long startTime=System.currentTimeMillis();
System.out.println("com.demomodel.query.threadPool.CallableFuture.demo2.TraffickingNarcoticsServiceImpl开始存入开始" +  DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
		int totalCount = 0;//traffickingNarcoticsOracleMapper.selectTraffickPointsCount(); //查询mysql
		System.out.println("com.demomodel.query.threadPool.CallableFuture.demo2.TraffickingNarcoticsServiceImpl总数: "+totalCount);//1138852
		int pageSize =20;//20 52028; // 每页内容
		int page = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		System.out.println("com.demomodel.query.threadPool.CallableFuture.demo2.TraffickingNarcoticsServiceImpl页数: "+page);
		int beginSize = 0;
	// 0 0-5 1 5-10 2 10 -15 oracle  0,10  10,10  20,10 mysql
	List<Callable<List<User2>>> task=new ArrayList<Callable<List<User2>>>();
	
	for (int i = 0; i < page; i++) {
		beginSize = pageSize * i;// 0*5 1*5 2*5                                  //oracle测试
		Callable<List<User2>> qfe=new TraffickingNarcoticsServiceImplThredQuery(beginSize, pageSize*(i+1));
		task.add(qfe);
	}
		ExecutorService executorService=Executors.newFixedThreadPool(100);
		List<Future<List<User2>>> futures=executorService.invokeAll(task);
	executorService.shutdown();//关闭线程池
	long endTime=System.currentTimeMillis();
	System.out.println("com.demomodel.query.threadPool.CallableFuture.demo2.TraffickingNarcoticsServiceImpl数结束  time: " + (endTime-startTime));
   //return selectHeterosexualRoomToPonits;
	}

}
