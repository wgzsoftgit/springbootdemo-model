package com.demomodel.fmiaosha.miaoshaxiadan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.toolkit.IdWorker;

@Component
public class CreateOrder implements Runnable {

    //注入redis模板对象
    @Autowired
    private RedisTemplate redisTemplate;

    //注入秒杀商品mapper接口代理对象
  //  @Autowired
   // private TbSeckillGoodsMapper seckillGoodsMapper;

    /**
     * 多线程实现下单
     * 
     * 1，从Redis队列中获取用户排队信息
     * 2，判断用户排队信息是否存在
     * 秒杀商品Id
     * 5，秒杀下单
     * 5.1 从redis服务器中获取入库的秒杀产品
     * 5.2 如果秒杀产品存在, 创建秒杀订单, 此订单此时处于未支付状态
     *  5.2.1 创建秒杀订单对象
     *  5.3 把新增订单储存在 Redis 服务器中
     */
    public void run() {
/*
        //1，从Redis队列中获取用户排队信息
        OrderRecode orderRecode =
                (OrderRecode) redisTemplate.boundListOps(SysConstants.SECKILL_USER_QUEUE).rightPop();

        //2，判断用户排队信息是否存在
        if (orderRecode != null) {
            // 3，如果用户存在，判断秒杀商品是否存在
            Long seckillGoodsId = (Long) redisTemplate.boundListOps(SysConstants.SECKILL_GOODSID_LIST + orderRecode.getSeckillId()).rightPop();
            // 4，如果秒杀商品不存在，表示秒杀商品已售罄
            if (seckillGoodsId == null) {
                throw new RuntimeException("已售罄");
            }
        }

        // 秒杀商品Id
        Long id = orderRecode.getSeckillId();
        // 用户 userId
        String userId = orderRecode.getUserId();

        // 5，秒杀下单
        // 5.1 从redis服务器中获取入库的秒杀产品
        TbSeckillGoods seckillGoods = (TbSeckillGoods) redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).get(id);

        // 5.2 如果秒杀产品存在, 创建秒杀订单, 此订单此时处于未支付状态
        // 5.2.1 创建秒杀订单对象
        TbSeckillOrder seckillOrder = new TbSeckillOrder();
        // 5.2.2 创建idWorder
        IdWorker idWorker = new IdWorker();
        seckillOrder.setId(idWorker.getId());
        // 5.2.3 设置秒杀订单属性值
        seckillOrder.setSellerId(seckillGoods.getSellerId());
        seckillOrder.setSeckillId(id);
        // 5.2.4 设置状态为未支付
        seckillOrder.setStatus("0");
        // 5.2.5 设置用户ID, 订单price, 下单时间
        seckillOrder.setUserId(userId);
        seckillOrder.setMoney(seckillGoods.getCostPrice());
        seckillOrder.setCreateTime(new Date());

        // 5.3 把新增订单储存在 Redis 服务器中
        // 参数1 : 订单唯一标识, 标识此数据时秒杀订单
        // 参数2 : userId , 用来标识此订单属于哪个用户
        // 参数3 : 秒杀订单数据
        redisTemplate.boundHashOps(TbSeckillOrder.class.getSimpleName()).put(userId,seckillOrder);

        // 5.4 下单后, 把秒杀商品库存减一
        seckillGoods.setStockCount(seckillGoods.getStockCount() - 1);

        // 5.5 判断库存是否小于0 , 卖完需要同步数据库
        if(seckillGoods.getStockCount() < 1){
            seckillGoodsMapper.updateByPrimaryKeySelective(seckillGoods);
            redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).delete(seckillGoods.getId());
        }else {
            // 5.6 否则把库存减少(但此时没有减为0) 的秒杀商品同步 Redis
            redisTemplate.boundHashOps(TbSeckillGoods.class.getSimpleName()).put(seckillGoods.getId(),seckillGoods);
        }

        // 5.7 已经创建订单的从Set 集合中移除
        redisTemplate.boundSetOps(SysConstants.SECKILL_USER_SET + id).remove(userId);
        */
    }
}
//https://blog.csdn.net/qq_42806915/java/article/details/82666254