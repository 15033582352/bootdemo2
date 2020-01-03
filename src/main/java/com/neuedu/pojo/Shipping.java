package com.neuedu.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Shipping {
    private Integer id;
    private Integer userId;
    private String  revicerName;
    private String revicerPhone;
    private String revicerMobile;
    private String revicerCity;
    private String revicerDistrict;
    private String revicerAddress;
    private String revicerZip;
    private Date  createTime;
    private Date updateTime;
}
