package com.chajiu.test;

import com.chajiu.pojo.User;
import com.chajiu.repo.UserRepo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mainTest {

    public static void main(String[] args) throws IOException {
        InputStream in;
        SqlSession session;
        UserRepo userRepo;
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        SqlSessionFactory sf=sfb.build(in);
        session = sf.openSession();
        userRepo = session.getMapper(UserRepo.class);

        System.out.println(userRepo.findById(1));
        session.close();

        SqlSession session1= sf.openSession();
        userRepo=session1.getMapper(UserRepo.class);
        System.out.println(userRepo.findById(1));

        session1.close();
        in.close();
    }

}
