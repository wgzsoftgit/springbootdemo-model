package com.demomodel.controller.baseController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class textcontroller extends BaseController{

	
	@RequestMapping
	public ResponseEntity<String> Responsetext() {
		Gson gson=new Gson();
		String src="[1]";
		String responsestr=gson.toJson(src);
		return new ResponseEntity<String>(responsestr,headers,HttpStatus.OK);
		
	}
	
}
