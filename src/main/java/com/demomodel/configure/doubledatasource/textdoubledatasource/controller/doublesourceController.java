package com.demomodel.configure.doubledatasource.textdoubledatasource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doublesourcetxt")
public class doublesourceController{

	@RequestMapping("primaryDataSourcetxt")
	public void primaryDataSource() {
		
	}
	@RequestMapping("otherDataSourcetxt")
      public void otherDataSource() {
		
	}
}
