package com.demomodel.configure.doubledatasource.textdoubledatasource.master.map;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demomodel.configure.doubledatasource.textdoubledatasource.master.dao.Demotxt;


//@Mapper
@Repository
public interface DemotxtMapper {
  
	List<Demotxt> selectALL();
}