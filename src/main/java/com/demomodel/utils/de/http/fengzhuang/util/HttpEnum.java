package com.demomodel.utils.de.http.fengzhuang.util;
/**
 * 请求类型
 * @author zbj
 *
 */
public enum  HttpEnum {
	
    GET(1,"get"),
    POST(2,"post"),
    PUT(3,"put"),
    DELETE(4,"delete");
    private int num;
    private String desc;


    HttpEnum(int num, String desc) {
        this.num = num;
        this.desc = desc;
    }
    public int getNum() {
        return num;
    }

    public String getDesc() {
        return desc;
    }
    public static void main(String[] args) {
		//使用方法	  HttpTestUtils中
    	System.err.println(HttpEnum.GET); 
		System.err.println(HttpEnum.GET.getNum()); 
	}
}
