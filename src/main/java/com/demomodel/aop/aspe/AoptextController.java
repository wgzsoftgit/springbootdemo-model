package com.demomodel.aop.aspe;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.aop.Target.Log;
import com.demomodel.bean.User;
import com.demomodel.bean.test1;

@Controller
@RequestMapping("aopRequest")
public class AoptextController {
//http://localhost:9093/aopRequest/aop?name=%27as%27&age=12
	@RequestMapping("aop")
	@ResponseBody
	@Log(operationType="add添加方法",operationName="operationName")
	public String aop(test1 user) {
		
		return "ok";
	}
	@RequestMapping("aop2")
	@ResponseBody
	@Log(operationType="add添加方法",operationName="operationName")
	public String aop2(test1 user) throws Exception {
		try {
			int i=3/0;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("controller 层 异常");
		}
		
		return "ok";
	}
}
