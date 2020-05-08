package com.demomodel.utils.de.gson.util.maptojson.bean;
public class Result<T>{
    public int code;
    public String message;
    public T data;
    // getter、setter
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public T getData() {
		return data;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setData(T data) {
		this.data = data;
	}
    
}