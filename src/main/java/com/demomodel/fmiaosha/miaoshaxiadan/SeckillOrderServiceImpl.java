package com.demomodel.fmiaosha.miaoshaxiadan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

/**
 * 服务实现层
 */
@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

    //注入redis模板对象
    @Autowired
    private RedisTemplate redisTemplate;

    //注入多线程对象
    @Autowired
    private CreateOrder createOrder;

    //注入调度对象
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    /**
     * 需求：提交订单
     * 参数：Long id String userId
     * 1），从redis服务器中获取入库的秒杀商品
     * 2），判断商品是否存在，商品库存是否小于等于0 
     * 3), 是否用户正在排队, 是否有未支付的订单
     * 4), 是否超出秒杀人数限制 
     * 5），满足条件，添加入秒杀用户队列 
     * 6），把待处理用户详情(userId, seckillgoodsId)存储在redis服务器中
     * 7），调用多线程创建秒杀订单, 此订单此时处于未支付状态
     */
    public void submitOrder(Long id, String userId) {
/*
        //1），从redis服务器中获取入库的秒杀商品
        TbSeckillGoods seckillGoods =
                (TbSeckillGoods) redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).get(id);
        // 2），判断商品是否存在，商品库存是否小于等于0
        if (seckillGoods == null || seckillGoods.getStockCount() < 1) {
            throw new RuntimeException("已售罄");
        }

        // 3), 是否用户正在排队, 是否有未支付的订单,  
        //从用户队列获取用户对象
        Boolean member = redisTemplate.boundSetOps(SysConstants.SECKILL_USER_SET + id).isMember(userId);
        //如果为true，表示此用户正在排队
        if (member) {
            //查询用户是否有订单
            Object order = redisTemplate.boundHashOps(TbSeckillOrder.class.getSimpleName()).get(userId);
            //判断订单是否为空
            if (order != null) {
                throw new RuntimeException("您还有订单未支付！");
            }

            throw new RuntimeException("您正在排队中.......");

        }

        // 4), 是否超出秒杀人数限制 
        //获取抢购此商品的人数
        int persons = redisTemplate.boundSetOps(SysConstants.SECKILL_USER_SET + id).members().size();
        //判断商品库存是否满足抢购人数需求
        if(persons >= seckillGoods.getStockCount()+200){
            throw new RuntimeException("排队人数过多...");
        }

        // 5），满足条件，添加入秒杀用户队列 
        // 6），把待处理用户详情(userId, seckillgoodsId)存入list集合进行排队
       redisTemplate.boundListOps(SysConstants.SECKILL_USER_QUEUE).leftPush(new OrderRecode(userId,id));
        //使用set集合记录用户排队
        redisTemplate.boundSetOps(SysConstants.SECKILL_USER_SET + id).add(userId);

        // 7），调用多线程创建秒杀订单, 此订单此时处于未支付状态
        taskExecutor.execute(createOrder);
*/
    }

}
//https://blog.csdn.net/qq_42806915/java/article/details/82666254