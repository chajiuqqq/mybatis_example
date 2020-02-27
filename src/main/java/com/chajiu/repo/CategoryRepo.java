package com.chajiu.repo;

import com.chajiu.pojo.Category;
import com.chajiu.pojo.Product;

import java.util.List;
import java.util.Map;

public interface CategoryRepo {
    List<Category> findAll();
    List<Category> findAll(Map<String,Integer> map);
    void add(Category category);

}
