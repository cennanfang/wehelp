package com.github.ichenkaihua.test.unit;

import com.alibaba.fastjson.JSON;
import com.cen.wehelp.model.User;
import com.cen.wehelp.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by chenkaihua on 15-9-15.
 */
public class UserServiceTest extends  BaseUnitTest{



    @Autowired
    UserService userService;


    @Test
//    @Ignore
    public void test(){
        User user = new User();
        user.setUserName("naying");
        List<User> users = userService.getUsers(user);
        System.out.println(users.size());
        System.out.println(JSON.toJSONString(users.get(0)));
    }

}
