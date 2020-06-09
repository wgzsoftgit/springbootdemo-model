package com.demomodel.mybatis.callBackFunction;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//多线程查数据和多线操作mybatis
//测试速度比较慢------------------不推荐
//@Component
//@EnableScheduling
public class SingPersonOccupancyServiceImpl2  {

//	@Autowired
//	SingPersonOccupancyMapper singPersonOccupancyMapper;
//	@Autowired
//	SingPersonOccupancyOracleMapper singPersonOccupancyOracleMapper;
	
	
//	   //前提同步旅馆信息hotelDetailsServiceImpl
//	@Scheduled(cron = "0 16 22 * * ?")
//	public void statisticsCheckInRoom2() throws InterruptedException, ExecutionException {
//		long startTime=System.currentTimeMillis();
//System.out.println("单人入住率开始" +  DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//		
//		int totalCount = singPersonOccupancyOracleMapper.selectAllCount(); //2:30  3 18 //1138852
//		System.out.println("单人入住率总数: "+totalCount);//1138852
//		int pageSize = 90000; // 每页内容
//		int page = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
//		System.out.println("单人入住率页数: "+page);
//		int beginSize = 0;
//		// 0 0-5 2 5-10 3 10 -15
//		//使用callable
//		List<Callable<List<SingPersonOccupancy>>> task=new ArrayList<Callable<List<SingPersonOccupancy>>>();
//		
//		for (int i = 0; i < page; i++) {
//			beginSize = pageSize * i;// 0*5 1*5 2*5
//			Callable<List<SingPersonOccupancy>> qfe=new ThredQuery(beginSize, pageSize*(i+1), singPersonOccupancyOracleMapper);
//			task.add(qfe);
//			
//		}
//			ExecutorService executorService=Executors.newFixedThreadPool(10);
//		List<Future<List<SingPersonOccupancy>>> futures=executorService.invokeAll(task);

	
	//          ThreadPoolExecutor executor=new ThreadPoolExecutor(10, 13, 30000, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(2000));
          
	//		if(futures !=null && futures.size()>0){
//			for (Future<List<SingPersonOccupancy>> future : futures) {
//				List<SingPersonOccupancy> list = future.get();
        
//				executor.execute(new  Runnable() {
//			public void run() {
//				for (SingPersonOccupancy temSingPersonOccupancy : list) {
//				System.out.println("单人开始操作mysql "); 
//				if(StringUtils.isNotBlank(temSingPersonOccupancy.getBusinessNum()) && StringUtils.isNotBlank(temSingPersonOccupancy.getHotelName()) &&  StringUtils.isNotBlank(temSingPersonOccupancy.getIdNum())){
//					
//					System.out.println("单人开始操作 "); 
//				SingPersonOccupancy tempWlist = singPersonOccupancyMapper.selectByBusinessNum(temSingPersonOccupancy.getBusinessNum());
//				if (tempWlist == null) {
//						singPersonOccupancyMapper.insertSelective(temSingPersonOccupancy);
//						System.out.println("单人入住率完成 ");   //第一次1001
//				} else {
//					if (temSingPersonOccupancy.equals(tempWlist)) {
//						temSingPersonOccupancy.setId(tempWlist.getId());
//						temSingPersonOccupancy.setUpTimeDate(new Date());
//						singPersonOccupancyMapper.updateByPrimaryKeySelective(temSingPersonOccupancy);
//						System.out.println("单人入住率更新完成 ");
//					}
//				}
//			  }
//			}
//			  }
//		   });	

//			}
//		}
//		executorService.shutdown();//关闭线程池
//		long endTime=System.currentTimeMillis();
//		System.out.println("单人入住率结束  time: " + (endTime-startTime));
//	
//	}
//	
//	

	

	
 
} 
