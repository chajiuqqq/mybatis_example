package com.chajiu.repo;

import com.chajiu.pojo.Category;
import com.chajiu.pojo.Product;

import java.util.List;

public interface CategoryRepo {
    List<Category> findAll();
}
