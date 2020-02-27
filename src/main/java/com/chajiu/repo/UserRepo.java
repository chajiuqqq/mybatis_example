package com.chajiu.repo;

import com.chajiu.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserRepo {

    List<User> findAll();
    User findById(Integer id);
    List<User> findLikeName(String name);

    List<User> findOlder(Map<String,Object> map);

    List<User> findUser(User user);

    List<User> findUserInList(List<Integer> uidList);
}
