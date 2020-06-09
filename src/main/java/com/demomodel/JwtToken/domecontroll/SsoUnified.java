package com.demomodel.JwtToken.domecontroll;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demomodel.JwtToken.demo.JwtHelper;
import com.demomodel.bean.User;
import com.demomodel.utils.redis.JedisPool.conf.RedisUtil;

import redis.clients.jedis.Jedis;
@Controller
@RequestMapping("SSO")
public class SsoUnified {
	private static Logger log = LoggerFactory.getLogger(SsoUnified.class); 
	@Autowired
	    RedisUtil redisUtil;
	/**
     * 验证cookie是否通过
     * @param cookieName cookie名称
     * @param cookieValue cookie内容
     * @return 是否认证成功
     */
    @GetMapping("/authcookies")
    public boolean checkAuthCookies (String cookieName, String cookieValue) {
        boolean isUpdate = true;//new JwtUtil(null,cookieValue).freeJwt();
        if ("jian".equals(cookieName) && "ok".equals(cookieValue)) {
            log.info("cookie验证通过");
            return true;
        }
        return false;
	}
 
	/**
	     * 统一验证登录中心
	     * @param username 用户名
	     * @param password 密码
	     */
	    @RequestMapping("Unifiedlogin")
	    public void checkLogin(HttpServletRequest request,String username, String password, String returnUrl,HttpServletResponse response) {
	        //TbUser user = userService.login(username, password); //查询数据库
	      User user = new User(); 
	        String jwtValue = null;
	        if (user != null) {
	            /*
	             * 获得uuid,作为tokenId（TGC）
	             * 将tokenId存进jedis，返回客户端以jwt存储的tokenId，
	             * 即使tokenId被截取也无所谓
	             */
	            String tokenId = UUID.randomUUID().toString();
	            //生成jwt
	           // jwtValue = new JwtUtil(tokenId, null).creatJwt();
	            //                              &&
	            String generateJWT = JwtHelper.generateJWT(tokenId, username, request.getHeader("user-agent"));
	            log.info("tokenId: " + tokenId+" jwt: "+generateJWT);
	            if (generateJWT != null) {
//	                Jedis jedis = jedisPool.getResource();
//	                jedis.set(tokenId, user.toString());
//	                jedis.expire(tokenId,1800);
	                redisUtil.setex(tokenId, 1800, generateJWT);//&&
	                log.info("查看key的剩余生存时间："+redisUtil.get(tokenId, 0));
	            }
	        }
	        //将jwt加密的TGC存进cookie
	        Cookie cookie = new Cookie("tokenId", jwtValue);
	        cookie.setPath("/"); //设置根域名
	        cookie.setHttpOnly(true);
	        response.addCookie(cookie);
	        try {
	            response.sendRedirect(returnUrl);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	//https://blog.csdn.net/zhangjingao/java/article/details/89052764
}

