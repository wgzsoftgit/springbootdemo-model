package com.demomodel.mybatisPlus.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demomodel.bean.User;
import com.demomodel.mybatisPlus.bean.TStudent;

/**
 * <p>
 * 学员表 Mapper 接口
 * </p>
 *
 * @author zzg123
 * @since 2018-07-15
 */
@Mapper
public interface TStudentMapper extends BaseMapper<TStudent> {
	/**
     * 
     * @Title: selectUserByMap
     * @Description: 多条件组合查找用户
     * @param userId
     * @return
     * @throws Exception
     */
	TStudent selectUserByMap(@Param("params") Map<String, Object> parameterMap) throws Exception;

List<User> selectUser();
}
//https://blog.csdn.net/zhouzhiwengang/java/article/details/81059086