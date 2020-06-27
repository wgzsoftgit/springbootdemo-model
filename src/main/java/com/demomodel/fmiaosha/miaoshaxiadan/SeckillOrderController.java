package com.demomodel.fmiaosha.miaoshaxiadan;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seckillOrder")
public class SeckillOrderController {

    @Reference()
    private SeckillOrderService seckillOrderService;

    /**
     * 需求：提交订单
     * 请求：../seckillOrder/submitOrder/'+id
     * 参数：@PathVariable Long id : 秒杀商品id
     */
    @RequestMapping("submitOrder/{id}")
    @CrossOrigin(origins = "http://item.pinyougou.com")
    public void submitOrder02(@PathVariable Long id, HttpServletRequest request){
       // ResultInfo resultInfo = null;
        String userId = request.getRemoteUser();
        try {
            seckillOrderService.submitOrder(id,userId);
       //     resultInfo = new ResultInfo<Object>(true,null,"秒杀成功");
        } catch (Exception e) {
            e.printStackTrace();
        //    resultInfo = new ResultInfo<Object>(false,null,e.getMessage());
        }
     //   return resultInfo;
    }

}
//https://blog.csdn.net/qq_42806915/java/article/details/82666254