package com.demomodel.JwtToken.jksjwt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.JwtToken.jksjwt.JwtHelper;
import com.demomodel.utils.redis.JedisPool.util.RedisConstants;
import com.demomodel.utils.redis.JedisPool.util.RedisUtil;
import com.demomodel.utils.redis.JedisPool.util.StateParameter;

@Controller
@RequestMapping("getJwtToken")
public class JwtToken {

	
	 @Autowired
	    RedisUtil redisUtil;
	 
	    /**
	     * 
	     * @return
	     */
	    @RequestMapping(value = "jwtgetRedis")
	    @ResponseBody
	    public String getRedis(){
	        String set = redisUtil.set("20182018","这是一条测试数据", RedisConstants.datebase1);
	        System.err.println(set);
	        Long resExpire = redisUtil.expire("20182018", 6000000, RedisConstants.datebase1);//设置key过期时间
	      
	        String res = redisUtil.get("20182018", RedisConstants.datebase1);
	        
	     // 生成JWT
	        Map<String, String> claims = new HashMap<>();
	        claims.put("id", "w1221");//user.getId()+
	        claims.put("nickName","ewwe" );//user.getNickName()
	        claims.put("login_method", "dwda");//userSocial.getLoginMethod()
	        claims.put("openId", "wqewqd");
	        claims.put("ts","r435f");// Instant.now().getEpochSecond()+""
	        String jwtToken = JwtHelper.genToken(claims);
	        // 缓存至redis
	        //renewToken(jwtToken, user.getId());//
	        redisUtil.set("wwwww",jwtToken,RedisConstants.datebase2);
	        
	        //保存到redis中
//	        private void renewToken(String token, int id) {
//	            redisTemplate.opsForValue().set(id, token);
//	            redisTemplate.expire(id, 30, TimeUnit.MINUTES);
//	        }
//	        退出登录的时候就直接delete掉就可以了
//
//	        public void invalidate(String token) {
//	            Map<String, String> map = JwtHelper.verifyToken(token);
//	            redisTemplate.delete(map.get("id"));
//	        }
	
//	        KeyPair keyPair = JwtRsaUtil.getInstance().getKeyPair();
//	        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJuaWNrTmFtZSI6IjEyMyIsIm9wZW5JZCI6Im9pWnFGd1d6ZlU2U05kZXRNakxhdkZMYXpPYmciLCJsb2dpbl9tZXRob2QiOiJ3ZWNoYXQiLCJpc3MiOiJzdW5TcHJpbmdfdXNlciIsImlkIjoiMjQiLCJleHAiOjE1MjA0MjczODEsInRzIjoiMTUyMDM0MDk4MSJ9.K-U9zakvABRTh1LmOPke_7zKH9qCEUC3CkqeSNknBv-6orsT87GVZZMJAYxp2wgyGe5EzObONRWaAde-EK2UGMe7yVGANjD5NaPw05d7gjO-2ZbhTOU1dpiTWH5zXXu6mdJUbjVNFwam5oh0qOgAelSKogQCf3pAnSdPAXG85Yc";
//	        Map<String, String> map = JwtHelper.verifyToken(token);
//	        System.out.println(map);

	        
	        
	        
	        
	        
	        
	        return jwtToken;

	     
	    }
}
