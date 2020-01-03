package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Product;
import com.neuedu.vo.ProductVo;

import java.util.List;

public interface IProductService {
    ServerResponse getAll();
    ServerResponse  addPro(Product product);
    ServerResponse getone(Integer id);
    List<ProductVo> proToVo(List<Product> pros);
}
