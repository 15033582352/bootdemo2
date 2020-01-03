package com.neuedu.service;

import com.neuedu.common.ResponseCode;
import com.neuedu.common.ServerResponse;
import com.neuedu.dao.UserDao;
import com.neuedu.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDao dao;
        @Override
    public ServerResponse getUsers() {
        return ServerResponse.serverSuccess("查询成功",dao.getUsers());
    }

    @Override
    public ServerResponse getUserByUsernameAndPassword(String username, String password) {


        if ("".equals(username)||username==null ){
            return ServerResponse.serverError("用户名不能为空");
        }
        if ("".equals(password)||password==null){
            return ServerResponse.serverError("密码不能为空");
        }
        User user=   dao.getUserByUsernameAndPassword(username,password);
        List<User> users=new ArrayList<>();
        if (user!=null){
            if (user.getRole()== ResponseCode.Code.MANAGER.getCode()){
                users.add(user);
                return ServerResponse.serverSuccess("登陆成功！",users);
            }else {
                return ServerResponse.serverError("权限不足");
            }
        }else {
            return ServerResponse.serverError("用户不存在！");
        }

    }

    @Override
    public ServerResponse addUser(User user) {
          if ("".equals(user.getUsername())||user.getUsername()==null){
              return ServerResponse.serverError("用户名不能为空");
          }
        if ("".equals(user.getPassword())||user.getPassword()==null){
            return ServerResponse.serverError("密码不能为空");
        }
        if (dao.getUserByUsername(user.getUsername())!=0){
            return ServerResponse.serverError("用户已存在");
        }
          int a=dao.addUser(user);
          if (a>0){
              return ServerResponse.serverSuccess("注册成功");
          }else{
              return ServerResponse.serverError("注册失败");
          }
    }

    @Override
    public ServerResponse getUserByUsername(String username) {
        if ("".equals(username)||username==null){
            return ServerResponse.serverError("请输入用户");
        }
      User user=  dao.getOneByUsername(username);
        if (user==null){
            return ServerResponse.serverError("该用户不存在");
        }
        List<User> users=new ArrayList<>();
        users.add(user);
        return ServerResponse.serverSuccess("用户存在,可以修改",users);
    }
    @Override
    public ServerResponse check_username(String username) {
        if ("".equals(username)||username==null){
            return ServerResponse.serverError("用户有误");
        }
        User user=  dao.getOneByUsername(username);
        if (user==null){
            return ServerResponse.serverSuccess("用户名可以使用");
        }else
        {
            return ServerResponse.serverSuccess("用户已存在");
        }
    }

    @Override
    public ServerResponse getOneByRole(String username, Integer role) {
        if ("".equals(username)||username==null){
            return ServerResponse.serverError("用户名不能为空");
        }
        if (role==null){
            return ServerResponse.serverError("角色不能为空");
        }
       User user= dao.getOneByRole(username,role);
        if (user==null){
            return ServerResponse.serverError("角色输入不正确");
        }else{
            return  ServerResponse.serverSuccess("角色输入正确可以修改密码");
        }
    }

    @Override
    public ServerResponse updateUser(String username, String password) {
        if ("".equals(username)||username==null){
            return ServerResponse.serverError("用户名不能为空");
        }
        if ("".equals(password)||password==null){
            return ServerResponse.serverError("密码不能为空");
        }
       int result= dao.getUserByUsername(username);
        if (result>0){
            int a=    dao.updateUser(username,password);
            if (a>0){
                return  ServerResponse.serverSuccess("密码修改成功");
            }else {
                return ServerResponse.serverError("密码修改失败");
            }
        }else{
            return ServerResponse.serverError("用户名不存在");
        }



    }
}
