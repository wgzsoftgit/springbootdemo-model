package com.demomodel.filter.midengFile.redismideng;

import java.util.concurrent.TimeUnit;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.bean.result.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/charge")
@AllArgsConstructor //生成全参数构造函数
public class ChargeController {    
    
    @RequestMapping("/startCharge")
    @CacheLock(prefix = "recharge",expire=60,timeUnit=TimeUnit.MINUTES)
    
    public Result startCharge(String  name, String pwd){
    	System.err.println("测试幂等性");
        return Result.success();
    }
}