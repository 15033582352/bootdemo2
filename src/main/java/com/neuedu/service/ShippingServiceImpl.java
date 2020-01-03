package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.ShippingDao;
import com.neuedu.pojo.Shipping;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShippingServiceImpl implements IShippingService{
     @Resource
     private ShippingDao shippingDao;
    @Override
    public ServerResponse getAll() {
        List<Shipping> shippings = shippingDao.getAll();
        if (shippings==null){
           return ServerResponse.serverError("shipping为空");
       }
        return ServerResponse.serverSuccess("查询成功",shippings);
    }

    @Override
    public ServerResponse addShipping(Integer userId, String revicerName, String revicerPhone, String revicerMobile, String revicerCity, String revicerDistrict, String revicerAddress, String revicerZip) {
       int a= shippingDao.addShipping(userId, revicerName, revicerPhone, revicerMobile, revicerCity, revicerDistrict, revicerAddress, revicerZip);
       if (a>0){
           return ServerResponse.serverSuccess("添加成功");
       }
        return ServerResponse.serverError("添加失败");
    }


}
