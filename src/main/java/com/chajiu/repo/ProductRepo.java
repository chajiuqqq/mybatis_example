package com.chajiu.repo;

import com.chajiu.pojo.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> findAll();
}
