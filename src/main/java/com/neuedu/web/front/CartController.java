package com.neuedu.web.front;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Cart;
import com.neuedu.service.ICartService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin("*")
@RestController
public class CartController {
    @Resource
    private ICartService service;
@RequestMapping("/front/getCart.do")
    public ServerResponse getCarts(Integer id,Integer count,Integer uid){
    Integer userId=uid;
        return service.getCarts(userId,id,count);
    }
    @RequestMapping("/front/updateCart.do")
    public ServerResponse updateCart(Integer userId,Integer proId,Integer checked){
        System.out.println(proId);
        return service.updateCart(userId,proId,checked);
    }
    @RequestMapping("/front/delByProId.do")
    public ServerResponse delByProId(Integer proId){
    return service.DelByProId(proId);
    }
    @RequestMapping("/front/updateDelCarts.do")
    public ServerResponse updateDelCarts(Integer userId){
    return service.updatedelCarts(userId);
    }
}
