package com.cen.wehelp.service;

import com.cen.wehelp.mapper.MessageMapper;
import com.cen.wehelp.model.Message;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by redbird on 2017/10/15.
 */
@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @RequiresRoles("admin")
    public List<Message> listMessages(){
        return messageMapper.selectAll();
    }
}
