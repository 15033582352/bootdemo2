package com.neuedu.web.back;

import com.neuedu.common.ServerResponse;
import com.neuedu.service.IShippingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
public class ShippingController {
    @Resource
    private IShippingService shippingService;
    @RequestMapping("/back/getShipping.do")
    public ServerResponse  getShipping(){
        return shippingService.getAll();
    }
    @RequestMapping("/back/addShipping.do")
    public ServerResponse addShipping(Integer userId, String revicerName, String revicerPhone, String revicerMobile, String revicerCity, String revicerDistrict, String revicerAddress, String revicerZip){
        System.out.println(userId);
       return shippingService.addShipping(userId, revicerName, revicerPhone, revicerMobile, revicerCity, revicerDistrict, revicerAddress, revicerZip);
    }

}
