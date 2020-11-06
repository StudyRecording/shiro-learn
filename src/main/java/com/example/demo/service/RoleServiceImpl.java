package com.example.demo.service;

import com.example.demo.dao.RoleDao;
import com.example.demo.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Roles> selectRoleAndPermByRoleId(Integer roleId) {
        return roleDao.selectRoleAndPermByRoleId(roleId);
    }
}
