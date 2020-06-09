package com.demomodel.mybatisPlus.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.activerecord.Model;
import com.demomodel.mybatisPlus.bean.TStudent;
import com.demomodel.mybatisPlus.service.TStudentService;

@Controller
@RequestMapping("/tStudent")
public class TStudentController {
	@Resource
	private TStudentService service;
 
	@RequestMapping("/get")
	@ResponseBody
	public TStudent get() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", 1);
		TStudent student = this.service.selectUserByMap(map);
		return student;
	}
 
}
//https://blog.csdn.net/zhouzhiwengang/java/article/details/81059086