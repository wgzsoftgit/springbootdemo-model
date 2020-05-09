package com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.dao.Usertimes;
import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.map.UsertimesMapper;
import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.service.UsertimesService;
@Service
public class UsertimesServiceImpl implements UsertimesService {

	@Autowired
	UsertimesMapper usertimesMapper;
	
	
	@Override
	public List<Usertimes> selectALL() {
		
		return usertimesMapper.selectALL();
	}

}
