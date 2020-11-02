package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    /**
     * 添加
     * @param user
     * @return
     */
    User add(User user);

    /**
     * 根据名字获取user数据
     * @param username
     * @return
     */
    User selectByUsername(String username);
}
