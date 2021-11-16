package com.chen.springbootmybatisplus;


import com.chen.bean.User;
import com.chen.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class Insert1Test {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User userBean = new User();
        userBean.setUserId(999);
        userBean.setName("insert test");
        userBean.setAge(30);
        userBean.setSex("男");
        userBean.setFace("Hello World".getBytes());
        userBean.setBorthday(new Date());

        int result = userMapper.insert(userBean);
        System.out.println("userBean=" + userBean);
        System.out.println("result=" + result);
    }

}
