package com.neuedu.web.front;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;
import com.neuedu.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class FrontOrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/front/order.do")
    public ServerResponse addOrder(Integer shippingId,Integer uid){
        System.out.println(shippingId+"===="+uid);
        return orderService.insertOrder(uid,shippingId);
    }
    @RequestMapping("/front/getOneOrder.do")
    public ServerResponse getOneOrder(){

        return orderService.getOneOrder();
    }
}
