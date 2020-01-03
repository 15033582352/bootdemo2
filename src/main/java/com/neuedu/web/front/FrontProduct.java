package com.neuedu.web.front;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;
import com.neuedu.service.IProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class FrontProduct {
  @Resource
    IProductService service;

    @RequestMapping("/front/getone.do")
    public ServerResponse getone(Integer id, HttpSession session){

        return service.getone(id);
    }
    @RequestMapping("/front/products.do")
  public ServerResponse products(){
      return service.getAll();
    }
}
