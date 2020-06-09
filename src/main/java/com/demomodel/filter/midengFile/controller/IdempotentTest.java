package com.demomodel.filter.midengFile.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.filter.midengFile.Idempotent;

import io.swagger.annotations.ApiOperation;
import junit.framework.Test;
import redis.clients.jedis.JedisCluster;
@RestController
@RequestMapping("IdempotentTest")
public class IdempotentTest {
	
	//@Autowired
	//@Qualifier("jedisCluster2")
	//JedisCluster  jedisCluster2;
	
	//localhost:9093/IdempotentTest/IdempotentIndex
	//@RequestBody Test test
	
	@Idempotent(body = true,bodyVals = {"loan:loanNumber"})
		@RequestMapping("IdempotentIndex")
		@ResponseBody
		public String add() {
		System.err.println("&&&&&&&&&&&7");
			return "ok";
		}
//	@RequestMapping("jedisClustertext")
//	public  void main(String[] args) {
//		jedisCluster2.set("test", "my forst jedis");
//     String str = jedisCluster2.get("test");
//      System.out.println(str);
//	}
	
	
	public void checkToken(HttpServletRequest request) {
//		String token = request.getHeader(TOKEN_NAME);
//		if (StringUtils.isBlank(token)) {// header中不存在token
//			token = request.getParameter(TOKEN_NAME);
//			if (StringUtils.isBlank(token)) {// parameter中也不存在token
//				throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
//			}
//		}
//
//		if (!jedisUtil.exists(token)) {
//			throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
//		}
//
//		Long del = jedisUtil.del(token);
//		if (del <= 0) {
//			throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
//		}
	}
	
}

//：https://blog.csdn.net/zhibo_lv/java/article/details/81905300