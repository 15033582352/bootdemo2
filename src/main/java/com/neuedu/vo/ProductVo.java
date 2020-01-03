package com.neuedu.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVo {
    //商品id
    private Integer proId;
    //是否选中
    private Integer checked;
    private String handleName;
    //购物车首页的小计
    private BigDecimal  total;
    //商品名称
    private String proName;
    private String subtitle;
    protected Integer stock;
    //图片
    private String proUrl;
    private  String proStatus;
    private String proDetail;
    //价格
    private Double price;
    //商品数量
    private Integer proQuantity;
    private String createTime;
    private String updateTime;

}
