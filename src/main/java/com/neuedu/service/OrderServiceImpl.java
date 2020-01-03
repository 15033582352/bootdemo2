package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.*;
import com.neuedu.pojo.*;
import com.neuedu.utils.DecimalUtils;
import com.neuedu.utils.OrderUtils;
import com.neuedu.utils.PropertiesUtil;
import com.neuedu.vo.CartVo;
import com.neuedu.vo.OrderVo;
import com.neuedu.vo.ProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private CartDao cartDao;
    @Resource
    private OrderDao orderDao;
    @Resource
    private ProductDao prodao;
    @Resource
    private IHandleDao handleDao;
    @Resource
    private OrderItemDao orderItemDao;
    @Resource
    private  UserDao userDao;
    @Resource
    private ShippingDao shippingDao;
    @Override
    public ServerResponse insertOrder(Integer userId, Integer shippingId) {
        //判断传进来的shippingId是否为空
        if (shippingId==null || "".equals(shippingId)){
            return ServerResponse.serverError("shippingId错误");
        }
        //查出来的购物车信息 通过userId
        List<Cart> cats=cartDao.getCarts(userId);

        //把购物车转成vo对象，获取到商品表里的价格
       CartVo cvo= cartToProVo(cats);
      //创建一个order对象set值
        Order order=new Order();
        order.setUserId(userId);
      //获取到vo转过来的价格获取到放到payment
        order.setPayment( cvo.getAllPrice());
        //放置shippingId  也就是他的地址信息
        order.setShippingId(shippingId);
        //通过utils生成的订单号
       Long OrderNo= OrderUtils.toOrderNo(new Date(),userId);
        order.setOrderNo(OrderNo.toString());
        //添加订单
        orderDao.insert(order);
        OrderVo orderVo=new OrderVo();
        orderVo.setUsername(userDao.getNameById(userId).getUsername());
       Shipping shipping= shippingDao.getAddressByShippingId(shippingId);
        orderVo.setAddress(shipping.getRevicerCity()+","+shipping.getRevicerDistrict()+","+shipping.getRevicerAddress());
        System.out.println(orderVo);
     //添加订单的同时需要把dorderitem模块添加上
        //因为是批量添加，使用的foreach  所以是list
        List<OrderItem> lists=new ArrayList<>();
        for (Cart cart:cats) {
            //new一个新的orderitem对象
            OrderItem orderItem=new OrderItem();

            orderItem.setOrderNo(order.getOrderNo());
            orderItem.setUserId(userId);
            //因为productId和ProductImage和ProductName目前拿不到，所以通过prodao.getone(cart.getId());
            //查询到当前product
            if (cart.getChecked() == 1) {
                Product product = prodao.getone(cart.getProductId());
                System.out.println(product);
                orderItem.setProductId(cart.getProductId());
                orderItem.setProductImage(PropertiesUtil.getValue("url") + product.getMainImage());
                orderItem.setProductName(product.getName());
                //当前商品的价格
                orderItem.setCurrentUnitPrice(BigDecimal.valueOf(product.getPrice()));
                orderItem.setQuantity(cart.getQuantity());
                orderItem.setTotalPrice(DecimalUtils.multiply(String.valueOf(product.getPrice()), String.valueOf(cart.getQuantity())));
                lists.add(orderItem);
            }

        }
        System.out.println(lists);
     int b= orderItemDao.insert(lists);
     //判断返回结果
     if (b>0) {
         return ServerResponse.serverSuccess("添加订单详情成功",Arrays.asList(orderVo));
     }
     return ServerResponse.serverError("添加订单失败");

    }

    @Override
    public ServerResponse getOneOrder() {
     Order order=orderDao.getOneOrder();
        System.out.println("aaaa"+order);
     if (order==null){
         return ServerResponse.serverError("显示订单失败");
     }
        return ServerResponse.serverSuccess("显示订单成功", Arrays.asList(order));
    }

    private CartVo cartToProVo(List<Cart> carts){
        CartVo cartVo=new CartVo();
        List<ProductVo> lists=new ArrayList<>();
        //选中的商品的价值和
        BigDecimal sum=new BigDecimal("0");
        int count=0;
        //遍历出来的购物车对象转换成vo对象,然后放入到list集合中
        for (Cart cart:carts
        ) {
            Product product= prodao.getone(cart.getProductId());
            System.out.println("测试"+product);
            ProductVo vo=new ProductVo();
            vo.setProId(cart.getProductId());
            vo.setSubtitle(product.getSubtitle());
            //通过依赖进来的Handledao把这个id的handle对象找出来获取到他的name
            vo.setHandleName(handleDao.getHandleByid(product.getHandleId()).getName());
            //自己封装的PropertiesUtil需要传一个key
            vo.setProUrl(PropertiesUtil.getValue("url")+product.getMainImage());
            vo.setProStatus("有效");
            //库存
            vo.setStock(product.getStock());
            vo.setPrice(product.getPrice());
            vo.setProDetail(product.getDetail());
            vo.setProQuantity(cart.getQuantity());
            vo.setChecked(cart.getChecked());
            //购物车页面的小计
            vo.setTotal(DecimalUtils.multiply(String.valueOf(product.getPrice()),String.valueOf(cart.getQuantity())));
            lists.add(vo);
            //判断是否全选设置计数器如果是零就加一如果大于零就不是全选
            if (cart.getChecked()==0){
                count++;
            }
            //如果被选中        total就等于 sum+ price*quantity
            if (cart.getChecked()==1){
                sum=DecimalUtils.add(sum.toString(),DecimalUtils.multiply(String.valueOf(product.getPrice()),String.valueOf(cart.getQuantity())).toString());
                cartVo.setAllPrice(sum);
            }
            cartVo.setVos(lists);
        }
        if (count>0){
            //allchecked=false
            cartVo.setAllChecked(0);
        }else {
            cartVo.setAllChecked(1);
        }

        return cartVo;
    }
}
