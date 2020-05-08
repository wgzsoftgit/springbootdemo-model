package com.demomodel.mysqlcontroller.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomodel.bean.master.ImplicitTerrorists;
import com.demomodel.mysqlcontroller.mapper.ImplicitTerroristsMapper;
import com.demomodel.mysqlcontroller.service.ImplicitTerroristsServic;


@Service
public class ImplicitTerroristsServicImpl  implements ImplicitTerroristsServic{

	@Autowired
	ImplicitTerroristsMapper implicitTerroristsMapper;
	@Override
	public List<ImplicitTerrorists> selectByTypeCondition(ImplicitTerrorists implicitTerrorists) {
		// TODO Auto-generated method stub
		return implicitTerroristsMapper.selectByTypeCondition(implicitTerrorists);
	}
	@Override
	public void updaControlStatesByarray(String[] checkboxValue) {
		// TODO Auto-generated method stub
		implicitTerroristsMapper.updaControlStatesByarray(checkboxValue);
	}
	
	public List<String> selectByRegion() {
		return implicitTerroristsMapper.selectByRegion();
	}
	

	
}
