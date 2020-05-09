package com.demomodel.configure.doubledatasource.textdoubledatasource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.configure.doubledatasource.textdoubledatasource.master.dao.Demotxt;
import com.demomodel.configure.doubledatasource.textdoubledatasource.master.map.DemotxtMapper;
import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.dao.Usertimes;
import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.map.UsertimesMapper;
import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.service.UsertimesService;


@RestController
@RequestMapping("doublesourcetxt")
public class doublesourceController{

	@Autowired
	DemotxtMapper demotxtMapper;
	@Autowired
	UsertimesService usertimesMapper;
	
	@RequestMapping("primaryDataSourcetxt")
	public List<Demotxt> primaryDataSource() {
		List<Demotxt>	 list =demotxtMapper.selectALL();
		return list;
	}
	@RequestMapping("otherDataSourcetxt")
      public List<Usertimes> otherDataSource() {
	List<Usertimes>	 list =usertimesMapper.selectALL();
	return list;
	}
}
