package com.demomodel.filter.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.demomodel.bean.result.CodeMsg;
import com.demomodel.bean.result.Result;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ItemController {
	/**
	 * http://localhost:9093/item/add { "id":1, "props":[{ "pid":22, "vid":323,
	 * "pidName":"namd", "vidName":"saasc" } ] }"
	 * 
	 * @param item
	 * @param bindingResult
	 */
	@RequestMapping("/item/add") // @RequestBody --
	public Result addItem(@Validated @RequestBody  Item item, BindingResult bindingResult) {
		System.err.println("测试检测");
		Map retMap = new HashMap();
		StringBuilder sb = new StringBuilder();
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError err : errors) {
				sb.append(err.getDefaultMessage() + "; ");
			}
			System.err.println( sb.toString());
			return Result.error(CodeMsg.PARAMETER_ISNULL);
		}  
		retMap.put("err", sb.toString());
		return Result.success(retMap);
	}
	 @PostMapping(value = "/validated")
	    public void verifyValidated(@Validated @RequestBody Item person, BindingResult result) {
	        log.info("I am verifyValidated() method, the request params is: 【{}】", JSON.toJSONString(person));
	        if (result.hasErrors()) {
	            FieldError fieldError = result.getFieldError();
	            if (fieldError != null) {
	                log.error("error msg: 【{}】", fieldError.getDefaultMessage());
	            }
	        }
	    }
	 
	 /**
	     * 使用注解验证字段
	     */
	    @PostMapping("/validatest")
	    public Result test(@Validated TestEntity testEntity, BindingResult result) {
	        if (result.hasErrors()) {
	            // br.getFieldError().getDefaultMessage()：获取错误信息
	        	 FieldError fieldError = result.getFieldError();
		            if (fieldError != null) {
		                log.error("error msg: 【{}】", fieldError.getDefaultMessage());
		            }
	        	return Result.error(CodeMsg.PARAMETER_ISNULL);
	        } 
	        return Result.success();
	    }
	//https://blog.csdn.net/weixin_45768481/java/article/details/106267976
}