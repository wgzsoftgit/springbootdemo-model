package com.demomodel.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.demomodel.bean.User;

public class test {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() 
	{
	    return sqlSessionTemplate;
	}
//https://blog.csdn.net/wlwlwlwl015/java/article/details/50246717
	public void insertCrossEvaluation(List<User> members)
            throws Exception {
        // TODO Auto-generated method stub
        int result = 1;
        SqlSession batchSqlSession = null;
        try {
            batchSqlSession = this.getSqlSessionTemplate()
                    .getSqlSessionFactory()
                    .openSession(ExecutorType.BATCH, false);// 获取批量方式的sqlsession
            int batchCount = 1000;// 每批commit的个数
            int batchLastIndex = batchCount;// 每批最后一个的下标
            for (int index = 0; index < members.size();) {
                if (batchLastIndex >= members.size()) {
                    batchLastIndex = members.size();
                    result = result * batchSqlSession.insert("MutualEvaluationMapper.insertCrossEvaluation",members.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
                    break;// 数据插入完毕，退出循环
                } else {
                    result = result * batchSqlSession.insert("MutualEvaluationMapper.insertCrossEvaluation",members.subList(index, batchLastIndex));
                    batchSqlSession.commit();
                    System.out.println("index:" + index+ " batchLastIndex:" + batchLastIndex);
                    index = batchLastIndex;// 设置下一批下标
                    batchLastIndex = index + (batchCount - 1);
                }
            }
            batchSqlSession.commit();
        } 
        finally {
            batchSqlSession.close();
        }
        
    }
//https://blog.csdn.net/wlwlwlwl015/java/article/details/50246717
}
