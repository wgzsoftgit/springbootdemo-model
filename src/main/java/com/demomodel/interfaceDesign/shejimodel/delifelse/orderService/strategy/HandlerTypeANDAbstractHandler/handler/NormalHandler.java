package com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.handler;

import org.springframework.stereotype.Component;

import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.OrderDTO;
import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.AbstractHandler;
import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.HandlerType;

@Component
@HandlerType("1")
public class NormalHandler extends AbstractHandler {

    @Override
    public String handle(OrderDTO dto) {
        return "处理普通订单";
    }

}