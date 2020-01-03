package com.neuedu.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class OrderItem {
    private Integer id;
    private Integer userId;
    private String orderNo;
    private Integer productId;
    private String productName;
    private String productImage;
    //当前商品的价格
    private BigDecimal currentUnitPrice;
    private Integer quantity;
    private BigDecimal totalPrice;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
