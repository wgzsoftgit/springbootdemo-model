/**
 * 
 */
package com.demomodel.yewu.peopleShopingtrank;


/**
 * @author wgz
 * @date 创建时间：2020年4月30日 上午5:32:40 
 */
//@Service
public class PotentialViolatedPeopleTransServiceImpl{
//
//	@Autowired
//	PotentialViolatedMapper potentialViolatedMapper; //调用oracle的sql
//	@Autowired
//	PotentialViolatedPeopleMapper potentialViolatedPeopleMapper;  //人的信息
//	@Autowired
//	PotentialViolatedPeopleTransRecordMapper potentialViolatedPeopleTransRecordMapper;//人买票信息
//	
//	
//	
//	@Override
//	public void syncPotentialViolatedPeopleTransRecord() {
	      //获取人的信息，查询多个人      从其他表清洗数据   list
//		List<PotentialViolatedPeople> potentialViolatedPeopleList = fetchPotentialViolatedPeople();
//		for(PotentialViolatedPeople pvp : potentialViolatedPeopleList) {
//			String idNum = pvp.getIdNum();
//			saveOrUpdate(pvp);//从个人的信息表中查询出用户的信息  存在就更新数据 不就存入 
//			
//			// 获取汽车票信息  根据用户id     list数据
//			List<PotentialViolatedPeopleTransRecord> busRecords = fetchBusRecords(idNum);
//			for(PotentialViolatedPeopleTransRecord busRecord : busRecords) {
//				busRecord.setIdNum(pvp.getIdNum());
//				saveOrUpdateRecord(busRecord); //根据票的id查询  出人的出行票  存在就更新数据 不就存入
//			}
//			
//			// 获取火车票信息
//			List<PotentialViolatedPeopleTransRecord> trainRecords = fetchTrainRecords(idNum);
//			for(PotentialViolatedPeopleTransRecord trainRecord : trainRecords) {
//				 trainRecord.setIdNum(pvp.getIdNum());
//				saveOrUpdateRecord(trainRecord);//根据票的id查询  出人的出行票  存在就更新数据 不就存入
//			}
//		}
//	}
//	
//	// 查询涉稳人员 oracle mapper
//	private List<PotentialViolatedPeople> fetchPotentialViolatedPeople() {
//		List<PotentialViolatedPeople> list =potentialViolatedMapper.selectfetchPotentialViolatedPeople();		
//		return list;
//		
//	}
//
//	// 查询个人汽车票 oracle mapper
//	private List<PotentialViolatedPeopleTransRecord> fetchBusRecords(String idNum) {
//		List<PotentialViolatedPeopleTransRecord> list=potentialViolatedMapper.selectPeopleAutomobileCar(idNum);
//		return list;
//	}
//	
//	// 查询个人火车票  oracle mapper
//	private List<PotentialViolatedPeopleTransRecord> fetchTrainRecords(String idNum) {
//		List<PotentialViolatedPeopleTransRecord> list=potentialViolatedMapper.selectPeopleTrainTickets(idNum);
//		return list;
//	}
//	
//	                // 保存或跟新涉稳人员
//	private void saveOrUpdate(PotentialViolatedPeople people) {
	       //从个人的信息表中查询出用户的信息
//		PotentialViolatedPeople result = potentialViolatedPeopleMapper.findByIdNum(people.getIdNum());
//		if( result != null) {
//			people.setId(result.getId());
//			update(people);  //存在就更新数据
//		} else {
//			save(people); //不存在就保存
//		}
//	}
//	
//	// 保存或跟新购票记录
//	private void saveOrUpdateRecord(PotentialViolatedPeopleTransRecord record) {
//		  //根据票的id查询  出人的出行票
//	 PotentialViolatedPeopleTransRecord result = potentialViolatedPeopleTransRecordMapper.findByTicketNum(record.getTicketNum());
//		if(result != null) {
//			record.setId(result.getId());
//			update(record); //存在就 更新
//		} else {
//			save(record);//不存在就保存
//		}
//	}
//	
//	// mysql poeple表
//	private void save(PotentialViolatedPeople people) {
//		potentialViolatedPeopleMapper.save(people);
//	}
//	
//	// mysql 购票记录表
//	private void save(PotentialViolatedPeopleTransRecord record) {
//		potentialViolatedPeopleTransRecordMapper.save(record);
//	}
//	
//	// mysql poeple表
//	private void update(PotentialViolatedPeople people) {
//		potentialViolatedPeopleMapper.update(people);
//	}
//	
//	// mysql 购票记录表
//	private void update(PotentialViolatedPeopleTransRecord record) {
//		potentialViolatedPeopleTransRecordMapper.update(record);
//	}
}
