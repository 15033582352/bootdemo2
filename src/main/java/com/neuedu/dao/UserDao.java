package com.neuedu.dao;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserDao {
   List<User> getUsers();
    User getUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    int addUser(User user);
    User getNameById(Integer userId);
    int getUserByUsername(@Param("username") String username);
    User getOneByUsername(@Param("username") String username);
    User getOneByRole(@Param("username") String username,@Param("role") Integer role);
    int updateUser(@Param("username") String username,@Param("password") String password);
}
