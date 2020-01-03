package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.UserDao;
import com.neuedu.pojo.OrderItem;
import com.neuedu.utils.PropertiesUtil;
import com.neuedu.vo.OrderItemVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderItemImpl implements IOrderItemService {
    @Resource
    private OrderItemDao orderItemDao;
    @Resource
    private UserDao userDao;
    @Override
    public ServerResponse getOrderItems(Integer userId) {
       if (userId==null||"".equals(userId)){
           return ServerResponse.serverError("id为空");
       }
    List<OrderItem> orderItems= orderItemDao.getOrderItems(userId);
   if (orderItems==null||"".equals(orderItems)){
       return ServerResponse.serverError("你还没有订单，请去购买商品");

   }
        List<OrderItemVo> lists=new ArrayList<>();
        for (OrderItem orderItem:orderItems) {
            System.out.println(orderItem);
            OrderItemVo orderItemVo=new OrderItemVo();
           orderItemVo.setUsername( userDao.getNameById(userId).getUsername());
           orderItemVo.setProductName(orderItem.getProductName());
            orderItemVo.setId(orderItem.getId());
            orderItemVo.setOrderNo(orderItem.getOrderNo());
            orderItemVo.setUpdateTime(orderItem.getUpdateTime());
            orderItemVo.setProUrl(orderItem.getProductImage());
            orderItemVo.setCurrentUnitPrice(orderItem.getCurrentUnitPrice());
            orderItemVo.setQuantity(orderItem.getQuantity());
            orderItemVo.setTotalPrice(orderItem.getTotalPrice());
            if (orderItem.getStatus()==0){
                orderItemVo.setStatus("未发货");
            }else if (orderItem.getStatus()==1){
                orderItemVo.setStatus("已发货");
            }
            else if (orderItem.getStatus()==2){
                orderItemVo.setStatus("已收货");
            }
            lists.add(orderItemVo);
            System.out.println("orderItemVo"+orderItemVo);
            System.out.println("aaaaa"+lists);
        }


   return ServerResponse.serverSuccess("订单查询成功",lists);
    }

    @Override
    public ServerResponse updateOrderItemStatus(Integer id, Integer status) {
    int a=    orderItemDao.updateOrderItemStatus(id, status);
    if (a>0){
        return ServerResponse.serverSuccess("修改成功");
    }
    else {
        return ServerResponse.serverError("修改失败");
    }
    }
}
