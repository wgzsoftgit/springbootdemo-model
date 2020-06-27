package com.demomodel.query.quartzdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demomodel.query.quartzdemo.demo.QuartzTaskInformations;
import com.demomodel.query.quartzdemo.service.query.QuartzService;
import com.demomodel.query.quartzdemo.util.Page;

import java.util.List;

/**
 * @ClassName IndexController
 * @Description 首页跳转controller
 * @Author simonsfan
 * @Date 2019/1/4
 * Version  1.0
 */
@Controller
@RequestMapping("IndexController")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private QuartzService quartzService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listTasks(Model model, @RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPage,
                            @RequestParam(value = "taskNo", required = false) String taskNo) {
        try {
            List<QuartzTaskInformations> taskList = quartzService.getTaskList(taskNo, currentPage);
           for (QuartzTaskInformations quartzTaskInformations : taskList) {
			System.err.println("/请求"+quartzTaskInformations.toString());
		}
            int current = Integer.parseInt(currentPage);
            Page<QuartzTaskInformations> page = new Page(taskList, taskList.size(), current);
            model.addAttribute("taskList", taskList);
            model.addAttribute("size", taskList.size());
            model.addAttribute("currentPage", page.getCurrentPage());
            model.addAttribute("totalPage", page.getTotalPage());
            model.addAttribute("taskNo", taskNo);
        } catch (Exception e) {
            logger.error("首页跳转发生异常exceptions-->" + e.toString());
        }
        return "query/index";
    }

}
