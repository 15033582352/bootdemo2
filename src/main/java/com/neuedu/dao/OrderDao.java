package com.neuedu.dao;

import com.neuedu.pojo.Order;

import java.util.List;

public interface OrderDao {
    int insert(Order order);
    Order getOneOrder();
}
