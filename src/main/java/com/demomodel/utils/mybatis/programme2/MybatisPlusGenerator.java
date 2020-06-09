package com.demomodel.utils.mybatis.programme2;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 自动生成bean和mapper和service和controller
 * myatis -plus逆向工程
 */
public class MybatisPlusGenerator {
	private static MybatisPlusGenerator single = null;
	
	private MybatisPlusGenerator() {
		super();
	}
	
	private static MybatisPlusGenerator getSingle() {
		if(single == null) {
			single =new MybatisPlusGenerator();
		}
		return single;
	}
	
	public void autoGeneration() {
		 GlobalConfig config = new GlobalConfig();
	        String dbUrl = "jdbc:mysql://localhost:3306/springboot?serverTimezone=GMT%2B8";
	        DataSourceConfig dataSourceConfig = new DataSourceConfig();
	        dataSourceConfig.setDbType(DbType.MYSQL)
	                .setUrl(dbUrl)
	                .setUsername("root")
	                .setPassword("root")
	                .setDriverName("com.mysql.cj.jdbc.Driver");
	        StrategyConfig strategyConfig = new StrategyConfig();
	        strategyConfig
	                .setCapitalMode(true)
	                .setEntityLombokModel(false)
	                .setDbColumnUnderline(true)
	                .setNaming(NamingStrategy.underline_to_camel);
	        config.setActiveRecord(false)
	                .setEnableCache(false)
	                .setAuthor("zzg")
	                //指定输出文件夹位置
	                .setOutputDir("D:\\workspace-eclipse\\tspringbootdemo\\src\\main\\java\\com\\demomodel\\utils\\mybatis\\programme2\\txt")
	                .setFileOverride(true)
	                .setServiceName("%sService");
	        new AutoGenerator().setGlobalConfig(config)
	                .setDataSource(dataSourceConfig)
	                .setStrategy(strategyConfig)
	                .setPackageInfo(
	                        new PackageConfig()
	                                .setParent("com.zzg.springboot")
	                                .setController("controller")
	                                .setEntity("entity")
	                ).execute();
	}
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MybatisPlusGenerator generator = MybatisPlusGenerator.getSingle();
		generator.autoGeneration();
		//自动生成bean和mapper和service和controller
	}
 
}
//：https://blog.csdn.net/zhouzhiwengang/java/article/details/81059086