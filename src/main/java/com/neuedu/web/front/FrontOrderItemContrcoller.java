package com.neuedu.web.front;

import com.neuedu.common.ServerResponse;
import com.neuedu.service.IOrderItemService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
public class FrontOrderItemContrcoller {
    @Resource
    private IOrderItemService orderItemService;
    @RequestMapping("/front/getOrderItems.do")
    public ServerResponse getOrderItems(Integer userId){
        return orderItemService.getOrderItems(userId);
    }
    @RequestMapping("/front/updateOrderItemStatus.do")
    public ServerResponse updateOrderItemStatus(Integer id,Integer status){
        return orderItemService.updateOrderItemStatus(id, status);
    }
}
