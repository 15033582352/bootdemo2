package com.neuedu.service;

import com.neuedu.common.ServerResponse;

public interface IOrderItemService {
    ServerResponse getOrderItems(Integer userId);
    ServerResponse updateOrderItemStatus(Integer id,Integer status);
}
