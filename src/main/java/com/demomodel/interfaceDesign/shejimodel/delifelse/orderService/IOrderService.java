package com.demomodel.interfaceDesign.shejimodel.delifelse.orderService;

public interface IOrderService {
 /**
  * 根据订单的不同类型做出不同的处理
  * @param dto
  * @return
  */
	String handle(OrderDTO dto);
}
