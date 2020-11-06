package com.example.demo.service;

import com.example.demo.entity.Roles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    List<Roles> selectRoleAndPermByRoleId(Integer roleId);
}
