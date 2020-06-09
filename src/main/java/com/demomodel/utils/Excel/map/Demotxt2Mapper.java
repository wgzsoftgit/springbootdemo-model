package com.demomodel.utils.Excel.map;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.demomodel.utils.Excel.bean.Demotxt2;


//@Mapper
//@Repository
@Resource
public interface Demotxt2Mapper {
  
	List<Demotxt2> selectALL();
	
	int selectById(@Param("id") int id);
}