package com.demomodel.controller.swagg;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.bean.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "数据中心", description = "数据中心文档说明") // ,hidden=true
@Controller
@RequestMapping("wsagg")
public class wsagg {

	//@ApiOperation(value = "获得用户列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response = “接口返回参数类型”, notes = “接口发布说明”；
	
	@ApiOperation(value = "获取标准数据", notes = "获取标准数据")
	@RequestMapping(value = "devicesManager", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody	
	public String datastest( @ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId) throws Exception {
	//	devicesManagerService.getDataTrend();
		return " 123null";
	}
	

	//传输数组
    @ApiOperation(value = "",notes = "")
    @ApiImplicitParam(name="chapters",value = "json数组传输",dataType = "EpChapter")
    @PostMapping("")
    public String multInsert(@RequestBody List<User> chapters){
        System.out.println(chapters);
        return  "ok";
    }
    
    //传输对象
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String createPerson(@RequestBody User person) {
        return "ok";
    }
    
}
