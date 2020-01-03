package com.neuedu.utils;

import java.math.BigDecimal;

public class DecimalUtils {
    public static BigDecimal add(String value1,String value2){
        BigDecimal b1=new BigDecimal(value1);
        BigDecimal b2=new BigDecimal(value2);
       return b1.add(b2);
    }
    public static BigDecimal subtract(String value1,String value2){
        BigDecimal b1=new BigDecimal(value1);
        BigDecimal b2=new BigDecimal(value2);
        return b1.subtract(b2);
    }
    public static BigDecimal multiply(String value1,String value2){
        BigDecimal b1=new BigDecimal(value1);
        BigDecimal b2=new BigDecimal(value2);
        return b1.multiply(b2);
    }
    public static BigDecimal divide(String value1,String value2){
        BigDecimal b1=new BigDecimal(value1);
        BigDecimal b2=new BigDecimal(value2);
        return b1.divide(b2);
    }
}
