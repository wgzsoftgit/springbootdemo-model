package com.demomodel.controller.ResultController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demomodel.bean.User;
import com.demomodel.controller.ResultController.Result.Result;
import com.demomodel.controller.ResultController.Result.ResultCodeEnum;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/domain")
public class DomainController {

   
/**
 * 统一返回结果       前端统一返回类型
 * @return
 */
    @GetMapping
    public Result<List<User>> getAllDomain () {
        List<User> domainList =null;  // domainService.selectAll();
        return new Result<>(ResultCodeEnum.SELECTSUCCESS,null,domainList);
    }

}
