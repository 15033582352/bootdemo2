package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.pojo.Product;
import com.neuedu.utils.PropertiesUtil;
import com.neuedu.vo.ProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductDao dao;
    @Resource
    private IHandleService handleService;

    @Override
    public ServerResponse getAll() {
       List<Product> products =dao.getAll();
        if (products==null){
            return ServerResponse.serverError("发生位置错误");
        }
        //把里面的mainimage转换成页面显示的
        List<Product> products2=new ArrayList<>();
        for (Product product1:products
             ) {
            product1.setMainImage(PropertiesUtil.getValue("url")+product1.getMainImage());
            products2.add(product1);
        }
        System.out.println("商品列表"+products2);

        return ServerResponse.serverSuccess("查询成功",products2);
    }

    @Override
    public ServerResponse addPro(Product product) {
        if (product == null) {
            return ServerResponse.serverError("product空");
        }
        {

            int result = dao.addPro(product);
            if (result>0){
                return ServerResponse.serverSuccess("添加成功");
            }else {
                return ServerResponse.serverError("添加失败");
            }

        }
    }

    @Override
    public ServerResponse getone(Integer id) {
        /*if (id==null){
            return ServerResponse
            .serverError("id kong");
        }*/
        System.out.println(id);
       Product product= dao.getone(id);
        if (product==null){
            return ServerResponse.serverError("product 为空");
        }
     List<Product> pros=   Arrays.asList(product);
       List<ProductVo> vos=  proToVo(pros);
        System.out.println("详情里面的"+vos);
        return ServerResponse.serverSuccess("查询成功",vos);
    }

    @Override
    public List<ProductVo> proToVo(List<Product> pros) {

        List<ProductVo> vos=new ArrayList<>();
        for (Product product:pros) {
            ProductVo vo=new ProductVo();
            vo.setProId(product.getId());
            vo.setProName(product.getName());
            vo.setPrice(product.getPrice());
            vo.setProDetail(product.getDetail());
            vo.setStock(product.getStock());
            if(product.getStatus()==1){
                vo.setProStatus("有效");
            }else {
                vo.setProStatus("无效");
            }
            vo.setSubtitle(product.getSubtitle());
            vo.setHandleName(handleService.getHandleById(product.getHandleId()).getName());

            vo.setProUrl(PropertiesUtil.getValue("url")+product.getMainImage());
        vos.add(vo);
        }
        return vos;

    }
}
