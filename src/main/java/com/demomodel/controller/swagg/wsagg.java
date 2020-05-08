package com.demomodel.controller.swagg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags = "数据中心", description = "数据中心文档说明") // ,hidden=true
@Controller
@RequestMapping("wsagg")
public class wsagg {

	@ApiOperation(value = "获取标准数据", notes = "获取标准数据")
	@RequestMapping(value = "devicesManager", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody	
	public String datastest(String url) throws Exception {
	//	devicesManagerService.getDataTrend();
		return " 123null";
	}
}
