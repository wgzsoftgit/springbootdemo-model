package com.demomodel.interfaceDesign.shejimodel.delifelse.orderService;

import java.math.BigDecimal;

public class OrderDTO {
private String code;
private BigDecimal price;
/**简单方式
 * 订单类型 
 * 1、普通订单
 * 2、团购订单
 * 3、促销订单
 */
private  String type;
public String getCode() {
	return code;
}
public BigDecimal getPrice() {
	return price;
}
public String getType() {
	return type;
}
public void setCode(String code) {
	this.code = code;
}
public void setPrice(BigDecimal price) {
	this.price = price;
}
public void setType(String type) {
	this.type = type;
}


}
