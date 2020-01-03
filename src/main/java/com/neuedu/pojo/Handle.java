package com.neuedu.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Handle {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer status;
    private Integer sortOrder;
    private Date createTime;
    private Date updateTime;
}
