package com.demomodel.oracle.service;

//oracle 分页查询
//@Service
//@Component
//@EnableScheduling
public class GaxxNewServiceImpl   {
//	@Autowired
//	GaZzrkjewMapper gaZzrkMapper;
//
//	@Autowired
//	TemporarytMapper temporaryPoptMapper;

	
//	查询白名单  并存入自己mysql
//	@Scheduled(cron = "0 20 10 * * ?")
//	@Override
//	public void selectSynTemporaryPopul() {
//		long startTime=System.currentTimeMillis();
//		System.out.println("" +  DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//		查询总数
//		int totalCount = gaZzrkMapper.selectAllCount(); //2:30  3 18 //1138852
//		System.out.println(" "+totalCount);//1138852
//		int pageSize = 90000; // 每页内容
//		int page = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
//		System.out.println(": "+page);
//		int beginSize = 0;
//		// 0 0-5 2 5-10 3 10 -15
//		for (int i = 0; i < page; i++) {
//			beginSize = pageSize * i;// 0*5 1*5 2*5
//			System.out.println("白名单分页开始" +  DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//			分页查询oracle数据库
	//List<TemporaryPopulationWhiteList> listColunt = gaZzrkMapper.selectByPage(beginSize, pageSize*(i+1));  //5:12 
//			System.out.println("白名单分页" +  DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
//			for (TemporaryPopulationWhiteList temporaryPopulationWhiteList : listColunt) {
//				if( StringUtils.isNotBlank(temporaryPopulationWhiteList.getXmname()) &&  StringUtils.isNotBlank(temporaryPopulationWhiteList.getIdNum())){
//				TemporaryPopulationWhiteList tempWlist = temporaryPoptMapper
//						.selectByIdNum(temporaryPopulationWhiteList.getIdNum());
//				if (tempWlist == null) {
//						// insert new
//						temporaryPopulationWhiteList.setIsUpdate(0);
//						temporaryPopulationWhiteList.setCreateDate(new Date());
//						temporaryPoptMapper.save(temporaryPopulationWhiteList);
//						System.out.println("白名单插入完成 " + i+1);   //第一次1001
//				} else {
	//判断对象是否是同一个
//					if (!temporaryPopulationWhiteList.equals(tempWlist)) {
//						tempWlist.setIsUpdate(1);
//						temporaryPoptMapper.update(tempWlist);
//					}
//				}
//				}
//			}
//		}
//		long endTime=System.currentTimeMillis();
//		System.out.println(" " + DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss")+(endTime-startTime));
//	}
	


}
