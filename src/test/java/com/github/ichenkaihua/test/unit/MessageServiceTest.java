package com.github.ichenkaihua.test.unit;

import com.alibaba.fastjson.JSON;
import com.cen.wehelp.model.Message;
import com.cen.wehelp.service.MessageService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by redbird on 2017/10/15.
 */
public class MessageServiceTest extends  BaseUnitTest {

    private Logger logger = LoggerFactory.getLogger(MessageServiceTest.class);

    @Autowired
    private MessageService messageService;

    @Test
    public void testListMassages() {
        List<Message> mesgs = messageService.listMessages();
        logger.info(JSON.toJSONString(mesgs));
    }
}
