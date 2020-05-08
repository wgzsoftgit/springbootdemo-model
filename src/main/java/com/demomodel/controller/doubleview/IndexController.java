package com.demomodel.controller.doubleview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IndexController {
    @GetMapping("/testJsp")
    public String testJsp(Model model) {
         model.addAttribute("message", "this is index jsp page");
        return "index";
    }

    @GetMapping("/testThemleaf")
    public String testThemleaf(Model model) {
        model.addAttribute("message", "this is index jsp page");
        return "thymeleaf/test";
    }

    @GetMapping("/testVue")
    public String testVue(Model model) {
        model.addAttribute("message", "this is index jsp page");
        return "vue/testVue";
    }


}
//https://blog.csdn.net/e_Inch_Photo/java/article/details/80201272