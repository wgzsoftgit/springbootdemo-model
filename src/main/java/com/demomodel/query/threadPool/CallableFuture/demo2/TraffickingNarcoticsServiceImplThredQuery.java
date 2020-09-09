package com.demomodel.query.threadPool.CallableFuture.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


import com.demomodel.bean.table.User2;

public class TraffickingNarcoticsServiceImplThredQuery implements Callable<List<User2>> {
	private int beganPage;
	private int pageSize;
//	@Autowired
//	TraffickingNarcoticsMapper traffickingNarcoticsMapper;

	
	public TraffickingNarcoticsServiceImplThredQuery(int beganPage, int pageSize //TraffickingNarcoticsMapper traffickingNarcoticsMapper
			) {
		this.beganPage = beganPage;
		this.pageSize = pageSize;
		//this.traffickingNarcoticsMapper=traffickingNarcoticsMapper;

	}


	@Override
	public List<User2> call() throws Exception {
		
		
			System.out.println("涉毒积分分页"+beganPage+pageSize);  
			List<User2> selectHeterosexualRoomToPonits =  null;// traffickingNarcoticsOracleMapper.selectTraffickPoints(beganPage, pageSize);
			if(selectHeterosexualRoomToPonits==null){
				selectHeterosexualRoomToPonits= new ArrayList<User2>();
			}

			
			for (User2 traffickingNarcotics : selectHeterosexualRoomToPonits) {
				if(StringUtils.isNotBlank(traffickingNarcotics.getPassWord())){
				
							 int telephoneHasNarcoticsMessageCounts=0; 
			
				System.err.println("积分  +"+telephoneHasNarcoticsMessageCounts);
			
				}
			}
			
			
			//traffickingNarcoticsMapper.insertforeach(selectHeterosexualRoomToPonits);//批量插入
			System.err.println("积分   插入    ok");
			
		
			
			


		return null;
	}
	private List<String> removeListItem(List<String> idNumList, String idNum) {
		if(StringUtils.isBlank(idNum)){  return idNumList;}
		final CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>(idNumList);
		for (String item : cowList) {
			if (item.equals(idNum)) {
				cowList.remove(item);
			}
		}
		return cowList;
	}

}
