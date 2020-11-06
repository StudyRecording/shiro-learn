package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Roles;
import com.example.demo.entity.User;
import com.example.demo.utl.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User add(User user) {

        String salt = SaltUtil.getSalt(4);

        // 密码定义的是hu970218
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
        user.setSalt(salt);
        int insert = userDao.insert(user);
        if (insert > 0) {
            return user;
        }

        return null;
    }

    @Override
    public User selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public User selectUserAndRolesByUsername(String username) {

        return userDao.selectUserAndRolesByUsername(username);
    }
}
