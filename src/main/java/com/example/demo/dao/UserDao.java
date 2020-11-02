package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User selectByUsername(@Param("username") String username);
}
