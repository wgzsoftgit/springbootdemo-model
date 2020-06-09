package com.demomodel.mybatisPlus.service.Impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demomodel.mybatisPlus.bean.TStudent;
import com.demomodel.mybatisPlus.dao.TStudentMapper;
import com.demomodel.mybatisPlus.service.TStudentService;

/**
 * <p>
 * 学员表 服务实现类
 * </p>
 *
 * @author zzg123
 * @since 2018-07-15
 */
@Service
public class TStudentServiceImpl extends ServiceImpl<TStudentMapper, TStudent> implements TStudentService {
	/**
     * 用户数据访问接口
     */
//	@Resource
	@Autowired
    private TStudentMapper tstudentMapper;
	@Override
	public TStudent selectUserByMap(Map<String, Object> parameterMap) throws Exception {
		// TODO Auto-generated method stub
		return tstudentMapper.selectUserByMap(parameterMap);
	}
 
}
//https://blog.csdn.net/zhouzhiwengang/java/article/details/81059086