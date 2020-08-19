package com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.IOrderService;
import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.OrderDTO;
import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.AbstractHandler;
import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.toSpring.HandlerContext;


/**
 * 中注入了HandlerContext，这是一个处理器上下文，
 * 用来保存不同的业务处理器，具体在下文会讲解。
 * 我们从中获取一个抽象的处理器AbstractHandler，
 * 调用其方法实现业务逻辑。
 * 
 * 现在可以了解到，我们主要的业务逻辑是在处理器中实现的，因此有多少个订单类型，
 * 就对应有多少个处理器。以后需求变化，增加了订单类型，只需要添加相应的处理器就可以，
 * 上述OrderServiceV2Impl完全不需改动
 * @author wgz
 * @date 创建时间：2020年7月21日 下午2:36:54
 */
public class OrderServiceV2Impl implements IOrderService {

	 @Autowired
	    private HandlerContext handlerContext;

	    @Override
	    public String handle(OrderDTO dto) {
	        AbstractHandler handler = handlerContext.getInstance(dto.getType());
	        return handler.handle(dto);
	    }

}
