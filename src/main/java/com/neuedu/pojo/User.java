package com.neuedu.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private Integer role;
    private Date createTime;
    private Date updateTime;

}
