package com.chen.springbootmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chen.bean.User;
import com.chen.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * selectById：根据 ID 查询
     */
    @Test
    void selectById() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 根据 ID 进行批量查询
     */
    @Test
    void selectBatchIds() {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        List<User> userBeanList = userMapper.selectBatchIds(ids);
        for(User userBean : userBeanList) {
            System.out.println(userBean);
        }
    }


    /**
     * 根据构建的 Wrapper 条件（根据ID查询用户信息）对象，使用 selectOne 查询数据，且只返回一个对象
     */
    @Test
    void QueryWrapperAndSelectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.le("user_id", 1);
        User userBean = userMapper.selectOne(wrapper);
        System.out.println(userBean);
    }

    /**
     * 获取数据总数，也可以使用 Wrapper 条件过滤数据
     */
    @Test
    void QueryWrapperAndSelectCount() {
        // 统计年龄大于等于 28 岁的用户数
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("age", 28);
        int count = userMapper.selectCount(wrapper);
        System.out.println("count=" + count);
    }

    @Test
    void query() {
        queryByWrapper(1, null, null);
        queryByWrapper(1, "赫仑", null);
        queryByWrapper(1, "赫仑", 27);
    }

    /**
     * 根据 userId、姓名和年龄查询条件创建一个 Wrapper 条件对象，查询用户列表
     * @param userId
     * @param name
     * @param age
     */
    private void queryByWrapper(int userId, String name, Integer age) {
        System.out.println("\n查询数据：");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        // 第一个参数为是否执行条件，为true则执行该条件
        // 下面实现根据 name 和 age 动态查询
        wrapper.eq(StringUtils.isNotEmpty(name), "name", name);
        wrapper.eq(null != age, "age", age);

        List<User> userBeanList = userMapper.selectList(wrapper);
        for(User userBean : userBeanList) {
            System.out.println(userBean);
        }
    }



    @Test
    void queryByMap() {
        queryByMap(1, null, null);
        queryByMap(1, "赫仑", null);
        queryByMap(1, "赫仑", 27);
    }

    private void queryByMap(int userId, String name, Integer age) {
        System.out.println("\n查询数据：");
        Map<String,Object> map = new HashMap<>();
        map.put("user_id", userId);

        // 第一个参数为是否执行条件，为true则执行该条件
        // 下面实现根据 name 和 age 动态查询
        if(StringUtils.isNotEmpty(name)) {
            map.put("name", name);
        }
        if(null != age) {
            map.put("age", age);
        }

        List<User> userBeanList = userMapper.selectByMap(map);
        for(User userBean : userBeanList) {
            System.out.println(userBean);
        }
    }




    @Test
    public void testSelect() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
