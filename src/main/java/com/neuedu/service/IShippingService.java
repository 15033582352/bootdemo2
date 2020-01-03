package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Shipping;

import java.util.List;

public interface IShippingService {
    ServerResponse getAll();
    ServerResponse addShipping( Integer userId,String revicerName, String revicerPhone, String revicerMobile, String revicerCity,String revicerDistrict, String revicerAddress,String revicerZip );
}
