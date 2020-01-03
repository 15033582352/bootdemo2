package com.neuedu.service;

import com.neuedu.common.ServerResponse;

public interface ICartService {
    ServerResponse getCarts(Integer userId,Integer id,Integer count);
    ServerResponse updateCart(Integer userId,Integer proId,Integer checked);
    ServerResponse DelByProId(Integer proId);
    ServerResponse updatedelCarts(Integer userId);
}
