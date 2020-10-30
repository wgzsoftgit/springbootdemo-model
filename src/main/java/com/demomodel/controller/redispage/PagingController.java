package com.demomodel.controller.redispage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import javax.sound.midi.Soundbank;
import java.util.List;

@RequestMapping("/redisPage")
@Controller
public class PagingController {
    @RequestMapping("/paging")
    public String paging(Model model, Long currentPage){
//        //create a simple and not-safe pool
//        Jedis jedis = new Jedis("localhost",6379);
//        try {
//            //total
//            long total = jedis.llen("nameList");
//            //size
//            long size = 10L;
//            if (total/size==0){
//                total = total/size;
//            }else {
//                total = total/size + 1;
//            }
//            // set currentPage
//            currentPage = currentPage==null?0L:currentPage;
//            System.out.println(total);
//            List<String> nameList = jedis.lrange("nameList",currentPage*size,(currentPage+1)*size);
//            model.addAttribute("nameList",nameList);
//            model.addAttribute("total",total);
//            model.addAttribute("currentPage",currentPage);
//            for (String name : nameList) {
//                System.out.println(name);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (jedis != null){
//                    jedis.close();
//                }
//            }catch (JedisException e){
//                e.printStackTrace();
//            }
//        }
       return "redisPage/redisPaging";
    }
}
