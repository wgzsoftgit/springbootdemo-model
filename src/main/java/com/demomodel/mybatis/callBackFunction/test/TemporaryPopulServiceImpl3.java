package com.demomodel.mybatis.callBackFunction.test;


//---------------------------ok----------------------------
////测试110 0000 s数据批量插入 4分钟ok
//@Component
//@EnableScheduling
//public class TemporaryPopulServiceImpl3  {
//
//	@Autowired
//	TemporaryPopulationWhiteListMapper temporaryPopulationWhiteListMapper;
//	@Autowired
//	GaZzrkjbxxNewMapper gaZzrkjbxxNewMapper;
//	//012  0   345 1  678 2  91011 3
//	//         1*3    2*3     3*3
//	
//		//30天酒店入住记录    //前提同步旅馆信息hotelDetailsServiceImpl
//		@Scheduled(cron = "0 54 21 * * ?")
//		public void statisticsCheckInRoom2() throws InterruptedException, ExecutionException {
//			long startTime=System.currentTimeMillis();
//	System.out.println("白名单开始" +  DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//			
//			int totalCount = gaZzrkjbxxNewMapper.selectAllCount(); //2:30  3 18 //113 8852
//			System.out.println("白名单总数: "+totalCount);//1138852
//			int pageSize = 60000; // 每页内容
//			int page = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
//			System.out.println("白名单页数: "+page);
//			int beginSize = 0;
//		// 0 0-5 2 5-10 3 10 -15
//		
//		List<Callable<List<TemporaryPopulationWhiteList>>> task=new ArrayList<Callable<List<TemporaryPopulationWhiteList>>>();
//		
//		for (int i = 0; i < page; i++) {
//			beginSize = pageSize * i;// 0*5 1*5 2*5
//			Callable<List<TemporaryPopulationWhiteList>> qfe=new TemporaryPopulationThredQuery3(beginSize, pageSize*(i+1), gaZzrkjbxxNewMapper, temporaryPopulationWhiteListMapper);
//			task.add(qfe);
//			
//		}
//		
//			ExecutorService executorService=Executors.newFixedThreadPool(100);
//			List<Future<List<TemporaryPopulationWhiteList>>> futures=executorService.invokeAll(task);
//	
//			
//			
//		executorService.shutdown();//关闭线程池
//		
//		long endTime=System.currentTimeMillis();
//		System.out.println("白名单结束  time: " + (endTime-startTime));
//	
//	}
//	
//	
//
//	
//
//	
// 
//} 
