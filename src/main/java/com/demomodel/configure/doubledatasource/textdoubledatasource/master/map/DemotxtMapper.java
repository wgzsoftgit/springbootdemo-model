package com.demomodel.configure.doubledatasource.textdoubledatasource.master.map;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.demomodel.configure.doubledatasource.textdoubledatasource.master.dao.Demotxt;


//@Mapper
@Repository //在Mapper扫描器中注册的注解类，因此它会被扫描
public interface DemotxtMapper {
  
	List<Demotxt> selectALL();  
	void insert();
	void insert2();
}