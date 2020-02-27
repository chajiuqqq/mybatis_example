package com.chajiu.test;

import com.chajiu.pojo.Role;
import com.chajiu.pojo.User;
import com.chajiu.pojo.UserRole;
import com.chajiu.repo.RoleRepo;
import com.chajiu.repo.UserRepo;
import com.chajiu.repo.UserRoleRepo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多对多中间表测试
 */
public class UserRoleTest {
    InputStream in;
    SqlSession session;
    UserRoleRepo userRoleRepo;
    UserRepo userRepo;
    RoleRepo roleRepo;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        SqlSessionFactory sf=sfb.build(in);
        session = sf.openSession();
        userRoleRepo = session.getMapper(UserRoleRepo.class);
        userRepo=session.getMapper(UserRepo.class);
        roleRepo=session.getMapper(RoleRepo.class);
    }

    @After
    public void destroy() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<UserRole> list=userRoleRepo.findAll();
        for(UserRole ur:list){
            System.out.println(ur);
        }

    }

    @Test
    public void save(){
        findAll();
        User user = userRepo.findById(1);
        Role role = roleRepo.findById(5);
        UserRole ur=new UserRole();
        ur.setUser(user);
        ur.setRole(role);

        userRoleRepo.save(ur);
        System.out.println("===");
        findAll();
    }

}
