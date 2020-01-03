package com.neuedu.web.front;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
public class FrontUserWeb {
    @Resource
    private IUserService service;
    @RequestMapping(value = "/front/add.do",method = RequestMethod.POST)
    public ServerResponse add(User user){
        return service.addUser(user);
    }
    //注册页 检查用户名是否已经存在
    @RequestMapping(value = "/front/check_username.do",method = RequestMethod.POST)
    public ServerResponse check_username(String username){
        return service.check_username(username);
    }
    //找回密码页，检查用户名是否存在
    @RequestMapping(value = "/front/get_username.do",method = RequestMethod.POST)
    public ServerResponse getUsername(String username){
        return service.getUserByUsername(username);
    }
    //找回密码页验证就相当于老师的答案和name
    @RequestMapping(value = "/front/get_role.do",method = RequestMethod.POST)
    public ServerResponse get_role(String username,Integer role){

        return service.getOneByRole(username,role);
    }
    @RequestMapping(value = "/front/update_user.do",method = RequestMethod.POST)
    public ServerResponse update_user(String username,String password){

        return service.updateUser(username,password);
    }

}
