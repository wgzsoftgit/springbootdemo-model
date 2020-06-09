package com.demomodel.oracle.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demomodel.bean.User;

public interface GaZzrkjbxxNewMapper {
	/**
	 * 查询出记录的总数
	 * @return
	 */
		Integer selectAllCount();
		/**
		 * 分页查询的内容
		 * @param beginSize
		 * @param pageSize
		 * @return
		 */
	List<User> selectByPage(@Param("beginSize")int beginSize, @Param("pageSize")int pageSize);
	}