package com.chajiu.test;

import com.chajiu.pojo.Category;
import com.chajiu.pojo.Role;
import com.chajiu.repo.CategoryRepo;
import com.chajiu.repo.RoleRepo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RoleTest {
    InputStream in;
    SqlSession session;
    RoleRepo roleRepo;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        SqlSessionFactory sf=sfb.build(in);
        session = sf.openSession();
        roleRepo = session.getMapper(RoleRepo.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<Role> roles=roleRepo.findAll();
        for(Role role:roles){
            System.out.println(role);
            System.out.println("\t\t"+role.getUsers());
        }

    }

}
