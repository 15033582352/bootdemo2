package com.neuedu.vo;

import com.neuedu.pojo.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderVo {
   private List<Order> orders;
   private String username;
   private String address;
}
