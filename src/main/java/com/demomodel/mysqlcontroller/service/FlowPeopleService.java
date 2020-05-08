package com.demomodel.mysqlcontroller.service;

import java.util.List;

import com.demomodel.bean.master.FlowPeople;


public interface FlowPeopleService {
/**
 * 根据对象查询
 * @param flowPeople 
 * @return
 */
	List<FlowPeople> selectByObject(FlowPeople flowPeople);
/**
 * 查询总条数
 * @param page
 * @param size
 * @return 
 */
	Integer flowSelectByPage(FlowPeople flowPeople);

}
