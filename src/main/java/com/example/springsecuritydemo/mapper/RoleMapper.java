package com.example.springsecuritydemo.mapper;

import com.example.springsecuritydemo.pojo.Role;

import java.util.List;

/**
 * @Auth tom
 * @Date 2023-03-28 14:56:51
 */
public interface RoleMapper {
    /**
     * 通过用户ID查询对应的角色信息
     * @param id
     * @return
     */
    List<Role> findRoleByUserId(Integer id);
}
