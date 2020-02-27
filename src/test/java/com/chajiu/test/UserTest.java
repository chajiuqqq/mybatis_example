package com.chajiu.test;

import com.chajiu.pojo.User;
import com.chajiu.repo.UserRepo;
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

public class UserTest {
    InputStream in;
    SqlSession session;
    UserRepo userRepo;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        SqlSessionFactory sf=sfb.build(in);
        session = sf.openSession();
        userRepo = session.getMapper(UserRepo.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userRepo.findAll();
        for(User user:users){
            System.out.println(user);
            System.out.println("\t\t" + user.getRoles());
        }

    }
    @Test
    public void findById(){
        User user = userRepo.findById(2);
        System.out.println(user);

    }

    @Test
    public void findLikeName(){
        List<User> users = userRepo.findLikeName("y");
        System.out.println(users);
    }
    @Test
    public void findOlder(){
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("name","y");
        map.put("id",9);
        List<User> users = userRepo.findOlder(map);
        System.out.println(users);
    }

}
