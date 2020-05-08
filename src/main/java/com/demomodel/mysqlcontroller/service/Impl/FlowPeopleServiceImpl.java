package com.demomodel.mysqlcontroller.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomodel.bean.master.FlowPeople;
import com.demomodel.mysqlcontroller.mapper.FlowPeopleMapper;
import com.demomodel.mysqlcontroller.service.FlowPeopleService;

@Service
public class FlowPeopleServiceImpl implements FlowPeopleService {

	@Autowired
	FlowPeopleMapper flowPeopleMapper;
	
	@Override
	public List<FlowPeople> selectByObject(FlowPeople flowPeople) {
	
		return flowPeopleMapper.selectByObject(flowPeople);
     
	}
	@Override
	public Integer flowSelectByPage(FlowPeople flowPeople) {
		
		return flowPeopleMapper.getFlowPeopleCount(flowPeople);
	}
  
	

}
