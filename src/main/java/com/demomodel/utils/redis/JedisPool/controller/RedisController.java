package com.demomodel.utils.redis.JedisPool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.utils.redis.JedisPool.util.RedisConstants;
import com.demomodel.utils.redis.JedisPool.util.RedisUtil;
import com.demomodel.utils.redis.JedisPool.util.StateParameter;
 
/**
 * @ClassName: RedisController
 * @Auther: zhangyingqi
 * @Date: 2018/8/29 16:15
 * @Description:
 */
@Controller
@RequestMapping(value="/redis")
public class RedisController extends BaseController {
    @Autowired
    RedisUtil redisUtil;
 
    /**
     * @auther: zhangyingqi
     * @date: 16:23 2018/8/29
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 执行redis写/读/生命周期
     * ,method = RequestMethod.POST
     */
    @RequestMapping(value = "getRedis")
    @ResponseBody
    public ModelMap getRedis(){
        String set = redisUtil.set("20182018","这是一条测试数据", RedisConstants.datebase1);
        System.err.println(set);
        Long resExpire = redisUtil.expire("20182018", 6000000, RedisConstants.datebase1);//设置key过期时间
        logger.info("resExpire="+resExpire);
        String res = redisUtil.get("20182018", RedisConstants.datebase1);
        return getModelMap(StateParameter.SUCCESS, res, "执行成功");
    }
 
}
//https://blog.csdn.net/zhulier1124/java/article/details/82193182