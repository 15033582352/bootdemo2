package com.neuedu.service;

import com.neuedu.common.ServerResponse;

public interface OrderService {
    ServerResponse insertOrder(Integer userId,Integer shippingId);
    ServerResponse  getOneOrder();
}
