package com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.toSpring;

import java.util.Map;

import com.demomodel.interfaceDesign.shejimodel.delifelse.orderService.strategy.HandlerTypeANDAbstractHandler.AbstractHandler;
import com.demomodel.utils.springcontextbeanutils.SpringBeanToolutil;
/**
 * 处理器上下文，根据类型获取相应的处理器
 * @author wgz
 * @date 创建时间：2020年7月21日 下午3:02:54
 */
@SuppressWarnings("unchecked")
public class HandlerContext {

    private Map<String, Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHandler getInstance(String type) {
        Class clazz = handlerMap.get(type);
        if (clazz == null) {
            throw new IllegalArgumentException("not found handler for type: " + type);
        }
        return (AbstractHandler) SpringBeanToolutil.getBean(clazz); //&& 
    }

}