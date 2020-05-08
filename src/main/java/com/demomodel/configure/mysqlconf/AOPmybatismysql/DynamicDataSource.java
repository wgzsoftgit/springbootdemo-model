package com.demomodel.configure.mysqlconf.AOPmybatismysql;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 动态数据源：继承AbstractRoutingDataSource 抽象类，
 * @author wgz
 * @date 创建时间：2020年4月24日 下午9:01:18
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
        return dataBaseType;
    }

}
//https://blog.csdn.net/tuesdayma/java/article/details/81081666