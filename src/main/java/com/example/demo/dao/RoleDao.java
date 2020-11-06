package com.example.demo.dao;

import com.example.demo.entity.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleDao {

    List<Roles> selectRoleAndPermByRoleId(@Param("id") Integer roleId);
}
