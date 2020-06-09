package com.demomodel.mybatis.callBackFunction.test;

//适合单线程
//@Component
//@EnableScheduling
//public class TemporaryPopulServiceImpl4  {
//
//	@Autowired
//	TemporaryPopulationWhiteListMapper temporaryPopulationWhiteListMapper;
//	@Autowired
//	GaZzrkjbxxNewMapper gaZzrkjbxxNewMapper;
//	@Autowired
//	SqlSessionFactory sqlSessionFactory;
//	//012  0   345 1  678 2  91011 3
//	//         1*3    2*3     3*3
//	
//		//30天酒店入住记录    //前提同步旅馆信息hotelDetailsServiceImpl
//		@Scheduled(cron = "0 43 10 * * ?")
//		public void statisticsCheckInRoom2() throws InterruptedException, ExecutionException {
//			long startTime=System.currentTimeMillis();
//	System.out.println("白名单开始" +  DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//			//: 1149863
//	//白名单页数: 20
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
//			Callable<List<TemporaryPopulationWhiteList>> qfe=new TemporaryPopulationThredQuery4(beginSize, pageSize*(i+1), gaZzrkjbxxNewMapper, temporaryPopulationWhiteListMapper , sqlSessionFactory);
//			task.add(qfe);
//			
//		}
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
