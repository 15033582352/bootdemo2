package com.neuedu.web.back;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
public class ProductContrcoller {
    @Resource
    private IProductService service;
    @RequestMapping("/back/add.do")
    public ServerResponse add(Product product){
        return service.addPro(product);
    }


}
