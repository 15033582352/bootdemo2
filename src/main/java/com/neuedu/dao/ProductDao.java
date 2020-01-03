package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAll();
    int addPro(Product product);
    Product  getone(Integer id);
}
