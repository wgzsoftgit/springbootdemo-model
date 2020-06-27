package com.demomodel.filter.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demomodel.bean.User;


@Controller
public class TestController {
 
 
    @CrossOrigin    //解决跨域问题@CrossOrigin(origins = "http://item.pinyougou.com")
    @RequestMapping("/user/login1")
    @ResponseBody
    public List<User> userLogin(User user) {
        System.out.println("com.demomodel.filter.core.TestController"+user);
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            users.add(user);
        }
        return users;
    }
}
//https://blog.csdn.net/lovePaul77/java/article/details/85681404