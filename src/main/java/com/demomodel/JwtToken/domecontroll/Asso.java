package com.demomodel.JwtToken.domecontroll;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demomodel.JwtToken.demo.JwtHelper;
import com.demomodel.JwtToken.demo.base.AESSecretUtil;
import com.demomodel.JwtToken.demo.base.SecretConstant;
import com.demomodel.utils.cookies.CookiesUtil;
import com.demomodel.utils.redis.JedisPool.conf.RedisUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.jsonwebtoken.Claims;
import redis.clients.jedis.Jedis;

public class Asso {
    private static Logger log = LoggerFactory.getLogger(Asso.class);
    @Autowired
    RedisUtil redisUtil;
    

    
    /**
     * 用户访问a.com，用户先验证cookie到达a.com/ssocheck
     * @return 响应界面：login/index
     */
    @GetMapping("/ssocheck")
    public ModelAndView checkCookies (HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("jian".equals(cookie.getName())) { //统一登录cookie为jian，如果存在就认证
                    log.info("cookie 存在，开始验证");
//                    HttpUtil httpUtil = new HttpUtil("http://sso.com/sso/authcookies", Method.GET);
//                    String result = httpUtil.send(cookie.getName(), cookie.getValue());
                    boolean authBoo  =true; //Boolean.valueOf(result);
                    if (authBoo) {
                        log.info("验证通过");
                        return new ModelAndView("public/index");//通过到达首页
                    }
                    break;
                }
            }
        }
        return new ModelAndView("index");//到达登录页面
    }
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return index/login
     */
    @PostMapping("/login")
    public ModelAndView doLogin (String username, String password) {
        if (username != null && !"".equals(username) &&
                    password != null && !"".equals(password) ) {
//            HttpUtil httpUtil = new HttpUtil("http://sso.com/sso/", "POST");
//            Result result = httpUtil.sendLogin(username,password);
            //如果验证通过，就携带所有子系统域名返回首页
            int isLogin =1; //result.getResultCode().getCode();
            if (isLogin == 1) {
                //@SuppressWarnings("all")
               // Map<String,String> param = (Map<String, String>) result.getData();
                return new ModelAndView("public/index","sendparam","1223");
            }
        }
        return new ModelAndView("index");
    }

//https://blog.csdn.net/zhangjingao/java/article/details/81735041
    /**
	     * 清除全局会话，子系统跳转到回到登录页的方法
	     * @param wlId 身份令牌
	     */
	    @GetMapping("/loginout")
	    public void loginOut(String wlId) {
	        log.info("clear token");
	        redisUtil.del(wlId);
	       
	    }

}

