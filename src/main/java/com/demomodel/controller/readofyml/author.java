package com.demomodel.controller.readofyml;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
author:
  name: 小鹏
  csdnUrl: http://www.baidu.com
 * @author wgz
 * @date 创建时间：2020年4月24日 上午10:26:23
 */
@Component
@ConfigurationProperties(prefix = "author") //得到application.yml的配置文可以不用配置@PropertySource("classpath:application.yml")
//@PropertySource("classpath:application.ym")
public class author {
    private  String name;

    private  String csdnUrl;

    public String getCsdnUrl() {
        return csdnUrl;
    }

    public void setCsdnUrl(String csdnUrl) {
        this.csdnUrl = csdnUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//https://blog.csdn.net/qq_40147863/article/details/84194493