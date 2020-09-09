package com.demomodel.configure.AOP.AOPErrro;

import lombok.Data;

@Data
public class JsonResponse<T> {

	private int status;
	
	private T data;
	
	private String message;

// 省略 getter setter
	
}