package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.CartDao;
import com.neuedu.dao.IHandleDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.pojo.Cart;
import com.neuedu.pojo.Product;
import com.neuedu.utils.DecimalUtils;
import com.neuedu.utils.PropertiesUtil;
import com.neuedu.vo.CartVo;
import com.neuedu.vo.ProductVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDate.now;

@SuppressWarnings("ALL")
@Service
public class CartServiceImpl implements ICartService{
    @Resource
    private CartDao cartDao;
    @Resource
    private ProductDao prodao;
    @Resource
    private IHandleDao  handleDao;
    @Override
    //加入购物车
    public ServerResponse getCarts(Integer userId,Integer id, Integer count) {
        if (userId==null|| "".equals(userId)){
            return ServerResponse.serverError("请登录");
        }
        if (id==null||"".equals(id)){
            return ServerResponse.serverError("商品信息有误");
        }
        if (count==null||"".equals(count)||count<=0){
            return ServerResponse.serverError("数量有误");
        }
       Cart cart= cartDao.getCartByUserAndPro(userId,id);
        System.out.println(cart);
        //如果根据id查出来的购物车为空，就说明不存在购物车，就创建一个新的购物车对象
        if (cart==null){
            Cart cart1=new Cart();
            cart1.setUserId(userId);
            cart1.setQuantity(count);
            cart1.setProductId(id);
             cartDao.insertCart(cart1);
            System.out.println("cart1"+cart1);
        }else {
            //如果已经有购物车，就要添加数量就可以
            cart.setQuantity(cart.getQuantity()+count);
            //添加完数量，就更新购物车内的quantity的值
            cartDao.updateCart(cart.getId(),cart.getQuantity());
        }
        //最后更新一遍购物车
       List<Cart> carts= cartDao.getCarts(userId);
        //把购物车对象转成vo
      CartVo vos=  cartToProVo(carts);
        System.out.println("购物车里面的对象"+vos);
        return ServerResponse.serverSuccess("成功", Arrays.asList(vos));
    }

    @Override
    public ServerResponse updateCart(Integer userId, Integer proId, Integer checked) {
        if (userId==null|| "".equals(userId)){
            return ServerResponse.serverError("请登录");
        }
        if (proId==null||"".equals(proId)){
            return ServerResponse.serverError("商品信息有误");
        }
        if (checked==null||"".equals(checked)){
            return ServerResponse.serverError("checked有误");
        }
        Cart cart= cartDao.getCartByUserAndPro(userId,proId);
        if (cart==null){
          return  ServerResponse.serverError("购物车有误");
        }else {
   int result=  cartDao.updateChecked(userId,proId,checked);
        }
        List<Cart> carts= cartDao.getCarts(userId);
        CartVo vos=  cartToProVo(carts);
        return ServerResponse.serverSuccess("成功", Arrays.asList(vos));
    }

    @Override
    public ServerResponse DelByProId(Integer proId) {
        int a=  cartDao.delByProId(proId);
        if (a>0){
            return  ServerResponse.serverSuccess("删除成功");
        }
        return  ServerResponse.serverError("删除失败");
    }

    @Override
    public ServerResponse updatedelCarts(Integer userId) {
      List<Cart> carts=  cartDao.getCarts(userId);
        return ServerResponse.serverSuccess("查询成功",carts);
    }

    //把购物车转成vo对象的方法
    //因为数量需要cart对象才能获取到，所以传一个cart对象
    private CartVo cartToProVo(List<Cart> carts){
        CartVo cartVo=new CartVo();
        List<ProductVo> lists=new ArrayList<>();
        //选中的商品的价值和
        BigDecimal sum=new BigDecimal("0");
        int count=0;
        //遍历出来的购物车对象转换成vo对象,然后放入到list集合中
        for (Cart cart:carts
        ) {
            //cart.getId()
     Product product= prodao.getone(cart.getProductId());
     ProductVo vo=new ProductVo();
            //cart.getId()
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
     vo.setProName(product.getName());
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
