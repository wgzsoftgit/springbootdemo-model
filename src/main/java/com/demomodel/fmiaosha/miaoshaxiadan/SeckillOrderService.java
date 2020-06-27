package com.demomodel.fmiaosha.miaoshaxiadan;
/**
 * 服务层接口
 */
public interface SeckillOrderService {

    /**
     * 需求：提交订单
     * 参数：Long id , String userId
     */
    void submitOrder(Long id, String userId);
}
//https://blog.csdn.net/qq_42806915/java/article/details/82666254