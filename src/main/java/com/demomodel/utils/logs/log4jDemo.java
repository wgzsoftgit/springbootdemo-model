package com.demomodel.utils.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
/**
 * 日志级别由高到底是：fatal -> error -> warn -> info -> debug,
 * 低级别的会输出高级别的信息，高级别的不会输出低级别的
 * @author wgz
 * @date 创建时间：2020年7月20日 上午11:24:17
 */

public class log4jDemo {
	//优点：使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
	 private static final Logger logger = LoggerFactory.getLogger(log4jDemo.class);
	 public static void main(String[] args) {
		 logger.debug("hello world");
		 
		 //说明：因为 String 字符串的拼接会使用 StringBuilder 的 append()方式，
		 //有一定的性能损耗。使用占位符仅是替换动作，可以有效提升性能
		 logger.info("这是一条数据:{}", JSON.toJSONString("对象"));
	}
}
