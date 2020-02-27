package com.chajiu.test;

import com.chajiu.pojo.Category;
import com.chajiu.pojo.Product;
import com.chajiu.repo.CategoryRepo;
import com.chajiu.repo.ProductRepo;
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

public class ProductTest {
    InputStream in;
    SqlSession session;
    ProductRepo productRepo;

    @Before
    public void init() throws IOException {
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
        SqlSessionFactory sf=sfb.build(in);
        session = sf.openSession();
        productRepo = session.getMapper(ProductRepo.class);
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<Product> products=productRepo.findAll();
        for(Product product:products){
            System.out.println(product);
            System.out.println("\t\t"+product.getCategory());
        }

    }

}
