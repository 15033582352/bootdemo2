package com.neuedu.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderItemVo {
    private Integer id;
    private String username;
    private String orderNo;
    private String productName;
    private  String proUrl;
    private String status;
    private BigDecimal currentUnitPrice;
    private Integer quantity;
    private BigDecimal totalPrice;
    private Date updateTime;
}
