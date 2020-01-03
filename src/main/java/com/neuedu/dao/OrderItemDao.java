package com.neuedu.dao;

import com.neuedu.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemDao {
    int insert(List<OrderItem> orderItem);
    List<OrderItem> getOrderItems(Integer userId);
    int updateOrderItemStatus(@Param("id") Integer id,@Param("status") Integer status);
}
