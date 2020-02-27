package com.chajiu.repo;

import com.chajiu.pojo.Role;

import java.util.List;

public interface RoleRepo {
    List<Role> findAll();
    Role findById(Integer id);
}
