package com.demomodel.mybatis;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demomodel.bean.User;
/**
 * 分页存入list    分批次插入数据
 * <insert id="insertBatch" parameterType="java.util.List">
    insert into t_risk_tolerance_answer (<include refid="Base_Column_List" /> )
    values 
    <foreach collection="list" item="item" index="index" separator=",">  
        (#{item.proposedCd,jdbcType=VARCHAR}, #{item.seq,jdbcType=INTEGER}, #{item.question,jdbcType=VARCHAR}, 
      #{item.answer,jdbcType=ARRAY,typeHandler=handler.ArrayTypeHandler}, 
      #{item.deleteFlg,jdbcType=VARCHAR}, #{item.createDt,jdbcType=TIMESTAMP}, #{item.createUserId,jdbcType=VARCHAR}, 
      #{item.updateDt,jdbcType=TIMESTAMP}, #{item.updateUserId,jdbcType=VARCHAR})
    </foreach>
    </insert>
https://blog.csdn.net/weixin_43886567/java/article/details/87927623
 * 
 * 不适合多线程，sqlSession.flushStatements();被其他线程提交
 *测试              多线程部分存入
 * @author wgz
 * @date 创建时间：2020年6月2日 下午10:29:47
 */
@Service
public class ProposedService {
@Autowired
SqlSessionFactory sqlSessionFactory;
//@Transactional
//public void insertBatch(List<User> tRiskToleranceAnswerList) {
//	int groupSize = 500;
//	int groupNo = tRiskToleranceAnswerList.size() / groupSize;
//	SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
//	UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//	if (tRiskToleranceAnswerList.size() <= groupSize) {
//		mapper.insertBatch(tRiskToleranceAnswerList);
//	} else {
//		List<User> subList=null;
//		for (int i = 0; i < groupNo; i++) {
//			subList = tRiskToleranceAnswerList.subList(0, groupSize);
//			mapper.insertBatch(subList);
//			tRiskToleranceAnswerList.subList(0, groupSize).clear();
//		}
//		if (tRiskToleranceAnswerList.size() > 0) {
//			mapper.insertBatch(tRiskToleranceAnswerList);
//		}
//	}
//	sqlSession.flushStatements();
// }
}
//https://blog.csdn.net/weixin_43886567/java/article/details/87927623