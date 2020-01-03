package com.neuedu.dao;

import com.neuedu.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartDao {
    int insertCart(Cart cart);
     Cart getCartByUserAndPro(@Param("userId") Integer userId,@Param("productId") Integer productId);
   int updateCart(@Param("id") Integer id,@Param("quantity") Integer quantity);
     List<Cart> getCarts(Integer userId);
     int updateChecked(@Param("userId") Integer userId,@Param("proId") Integer prioId,@Param("checked") Integer checked);
     int delByProId(Integer proId);

}
