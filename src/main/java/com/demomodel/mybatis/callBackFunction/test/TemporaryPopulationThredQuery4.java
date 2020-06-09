package com.demomodel.mybatis.callBackFunction.test;

//不适合多线程
//public class TemporaryPopulationThredQuery4  implements Callable<List<TemporaryPopulationWhiteList>>{
//
//	private int beganPage;
//	private int pageSize;
//	@Autowired
//	GaZzrkjbxxNewMapper gaZzrkjbxxNewMapper;
//	@Autowired
//	TemporaryPopulationWhiteListMapper temporaryPopulationWhiteListMapper;
//	@Autowired
//	SqlSessionFactory sqlSessionFactory;
//	
//	
//	public TemporaryPopulationThredQuery4(int beganPage, int pageSize, GaZzrkjbxxNewMapper gaZzrkjbxxNewMapper,TemporaryPopulationWhiteListMapper temporaryPopulationWhiteListMapper,SqlSessionFactory sqlSessionFactory) {
//		this.beganPage = beganPage;
//		this.pageSize = pageSize;
//		this.gaZzrkjbxxNewMapper = gaZzrkjbxxNewMapper;
//		this.temporaryPopulationWhiteListMapper=temporaryPopulationWhiteListMapper;
//		this.sqlSessionFactory=sqlSessionFactory;
//	}
//
//	@Override
//	public List<TemporaryPopulationWhiteList> call() throws Exception {
//		System.out.println("白名单分页"+beganPage+pageSize);  
//		List<TemporaryPopulationWhiteList> listColunt = gaZzrkjbxxNewMapper.selectByPage(beganPage, pageSize);
//		if(listColunt==null){
//			listColunt= new ArrayList<TemporaryPopulationWhiteList>();
//		}
//	//	temporaryPopulationWhiteListMapper.insertSave(listColunt);
//		
//		int groupSize=500;
//		int groupNo=listColunt.size() / groupSize;
//		SqlSession sqlSession= sqlSessionFactory.openSession(ExecutorType.BATCH);
//		TemporaryPopulationWhiteListMapper mapper = sqlSession.getMapper(TemporaryPopulationWhiteListMapper.class);
//		if(listColunt.size() <= groupSize){
//			mapper.insertSave(listColunt);
//		//	System.err.println(Thread.currentThread().getName()+"直接插入");
//		}else{
//			List<TemporaryPopulationWhiteList> subList=null;
//			for (int i = 0; i < groupNo; i++) {
//				subList=listColunt.subList(0, groupSize);
//				mapper.insertSave(subList);
//			//	System.err.println(Thread.currentThread().getName()+"分批插入"+subList.size());
//				listColunt.subList(0, groupSize).clear();
//			}
//			if(listColunt.size()>0){
//				mapper.insertSave(listColunt);
//			//	System.err.println(Thread.currentThread().getName()+"最后插入");
//			}
//		}
//		System.out.println(Thread.currentThread().getName()+"白名单插入完成 "); 
//		sqlSession.flushStatements();
//		return null;
//	}
//
//	
//
//	
//}
