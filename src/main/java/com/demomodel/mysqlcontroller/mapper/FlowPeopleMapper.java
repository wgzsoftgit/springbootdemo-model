package com.demomodel.mysqlcontroller.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.demomodel.bean.master.FlowPeople;

@Mapper
public interface FlowPeopleMapper {
	/**
	 * 根据对象分页查询数据
	 * @param flowPeople
	 * @return
	 */
	List<FlowPeople> selectByObject(FlowPeople flowPeople);



//查询总数  根据条件 
Integer getFlowPeopleCount(FlowPeople flowPeople);


//分页查询
//List<FlowPeople> flowSelectByPage(@Param("startPage")Integer startPage,@Param("size") Integer size);

}