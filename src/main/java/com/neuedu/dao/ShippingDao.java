package com.neuedu.dao;

import com.neuedu.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingDao {
    List<Shipping> getAll();
    int addShipping(@Param("userId") Integer userId,@Param("revicerName") String revicerName,@Param("revicerPhone") String revicerPhone,@Param("revicerMobile") String revicerMobile,@Param("revicerCity") String revicerCity,@Param("revicerDistrict") String revicerDistrict,@Param("revicerAddress") String revicerAddress,@Param("revicerZip") String revicerZip );
    Shipping getAddressByShippingId(Integer shippingId);

}
