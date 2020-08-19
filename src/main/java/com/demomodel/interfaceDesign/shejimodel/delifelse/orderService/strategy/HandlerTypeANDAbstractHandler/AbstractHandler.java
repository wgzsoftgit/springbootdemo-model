package com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler;

import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.OrderDTO;
/**
 * 抽象处理器 
 * @author wgz
 * @date 创建时间：2020年7月21日 下午2:44:29
 */
public abstract class AbstractHandler {

	abstract public String handle(OrderDTO dto);
}
