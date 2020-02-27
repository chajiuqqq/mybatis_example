package com.chajiu.repo;

import com.chajiu.pojo.UserRole;

import java.util.List;

public interface UserRoleRepo {

    List<UserRole> findAll();
    void save(UserRole userRole);
}
