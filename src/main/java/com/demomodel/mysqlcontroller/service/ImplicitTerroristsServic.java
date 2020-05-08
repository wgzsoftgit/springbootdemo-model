package com.demomodel.mysqlcontroller.service;

import java.util.List;

import com.demomodel.bean.master.ImplicitTerrorists;

public interface ImplicitTerroristsServic {

	List<String> selectByRegion();

	List<ImplicitTerrorists> selectByTypeCondition(ImplicitTerrorists implicitTerrorists);

	void updaControlStatesByarray(String[] checkboxValue);

}
