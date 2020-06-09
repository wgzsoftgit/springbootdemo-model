package com.demomodel.query.Schedulequery.dao;

import java.util.List;

import org.mapstruct.Mapper;

import com.demomodel.query.Schedulequery.bean.ScheduleConfig;
@Mapper
public interface ScheduleDao {
	
	public List<ScheduleConfig> getScheduleList();
}

