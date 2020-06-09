package com.demomodel.mybatisPlus.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.demomodel.mybatisPlus.bean.TStudent;

/**
 * <p>
 * 学员表 服务类
 * </p>
 *
 * @author zzg123
 * @since 2018-07-15
 */
public interface TStudentService extends IService<TStudent> {
	/**
     * 
     * @Title: selectUserByMap
     * @Description: 多条件组合查找用户
     * @param userId
     * @return
     * @throws Exception
     */
	TStudent selectUserByMap(Map<String, Object> parameterMap) throws Exception;
}
//https://blog.csdn.net/zhouzhiwengang/java/article/details/81059086