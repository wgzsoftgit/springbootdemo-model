package com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.demomodel.configure.doubledatasource.textdoubledatasource.secondary.dao.Usertimes;

@Mapper
public interface UsertimesMapper {  
 
	List<Usertimes> selectALL();
}