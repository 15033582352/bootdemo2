package com.neuedu.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
@Data
public class CartVo {
    private Integer allChecked;
    private List<ProductVo> vos;
    //购物车下方的总计
    private BigDecimal allPrice;
}
