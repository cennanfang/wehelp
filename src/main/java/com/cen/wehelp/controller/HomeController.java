package com.cen.wehelp.controller;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by chenkaihua on 15-12-15.
 */
@Controller
@RequestMapping("")
@ApiIgnore
public class HomeController {

    public Logger logger = LoggerFactory.getLogger(HomeController.class);

    //首页跳转到api页面
    @RequestMapping("index")
    public ModelAndView home(){
        logger.info("------------index home--------------");
        return new ModelAndView("redirect:swagger-ui.html");
    }


}
