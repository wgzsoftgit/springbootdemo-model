package com.demomodel.utils.httpHelp.WebMagic.piple;

import org.springframework.stereotype.Component;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class SpringDate implements Pipeline {
//ResultItems保存了抽取结果，他是一个map
	//page.putField(key,value)中保存数据
	//可以通过ResultItems.get(key)获取
	@Override
	public void process(ResultItems resultItems, Task task) {
		Object object = resultItems.get("jobInfo");
		if(object != null) {
			//保存到数据库   调用mapper层
			System.err.println(1);
		}

	}

}
