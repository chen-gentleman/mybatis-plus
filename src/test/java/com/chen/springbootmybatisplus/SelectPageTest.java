package com.chen.springbootmybatisplus;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.bean.User;
import com.chen.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class SelectPageTest {
    @Autowired
    private UserMapper userMapper;


    /**
     * 使用 QueryWrapper 和 Page 作为参数进行分页
     */
    @Test
    void selectPage() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("user_id");

        // 创建分页对象（1表示第一页；4表示每页大小为4）
        Page<User> page = new Page<>(2, 2);
        Page<User> result = userMapper.selectPage(page, wrapper);
        System.out.println("page == result: " + (page == result));
        System.out.println("size: " + result.getSize());
        System.out.println("total: " + result.getTotal());
        for(User userBean : result.getRecords()) {
            System.out.println(userBean);
        }
    }

    @Test
    void contextLoads() {
        // 返回的结果类型为 Map<String,Object>
        Page<Map<String,Object>> page = new Page<>(1, 4);
        userMapper.selectMapsPage(page, null);
        System.out.println("size: " + page.getSize());
        System.out.println("total: " + page.getTotal());
        System.out.println("pages: " + page.getPages());
        for(Map<String,Object> map : page.getRecords()) {
            System.out.println(map);
        }
    }
}
