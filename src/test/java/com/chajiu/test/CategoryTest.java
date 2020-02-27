package com.chajiu.test;

import com.chajiu.pojo.Category;
import com.chajiu.pojo.User;
import com.chajiu.repo.CategoryRepo;
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

public class CategoryTest {
    InputStream in;
    SqlSession session;
    CategoryRepo categoryRepo;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        SqlSessionFactory sf=sfb.build(in);
        session = sf.openSession();
        categoryRepo = session.getMapper(CategoryRepo.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<Category> categories=categoryRepo.findAll();
        for(Category category:categories){
            System.out.println(category);
            System.out.println("\t\t"+category.getProducts());
        }

    }

}
