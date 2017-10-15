package com.cen.wehelp.controller;

import com.alibaba.fastjson.JSON;
import com.cen.wehelp.model.Message;
import com.cen.wehelp.service.MessageService;
import com.cen.wehelp.utils.ResponseJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by redbird on 2017/10/15.
 */
@RestController
@RequestMapping("mesgs")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public void listMessages(HttpServletResponse response)  throws Exception {
        List<Message> mesgs = messageService.listMessages();
        ResponseJsonUtils.returnJson(response, JSON.toJSONString(mesgs));
     }
}
