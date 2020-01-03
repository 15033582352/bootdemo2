package com.neuedu.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Integer id;
    private Integer handleId;
    private String name;
    private String subtitle;
    private String mainImage;
    private String subImage;
    private String detail;
    private Double price;
    private Integer stock;
    private Integer status;
    private Date  createTime;
    private Date updateTime;
}
