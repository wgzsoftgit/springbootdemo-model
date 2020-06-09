package com.demomodel.query.Schedulequery.controllertext;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduledTaskRegistrarText {

	@RequestMapping("scheduledTaskRegistrartext")
	public String schedutask() {
		System.err.println("数据库查询出的定时任务"+"com.demomodel.query.Schedulequery.controllertext.ScheduledTaskRegistrarText");
	return "ok";
	}
	@RequestMapping("scheduledTaskRegistrartext2")
	public String schedutask2() {
		System.err.println("数据库查询出的定时任务2"+"com.demomodel.query.Schedulequery.controllertext.ScheduledTaskRegistrarText");
	return "ok";
	}
}
