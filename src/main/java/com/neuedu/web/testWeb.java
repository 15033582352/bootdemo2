package com.neuedu.web;

import com.neuedu.common.ResponseCode;
import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
@CrossOrigin("*")
@RestController
public class testWeb  {
    @Resource
    private IUserService service;
    @RequestMapping("/login.do")
    public ServerResponse login(String username, String password, HttpSession session){
       ServerResponse serverResponse= service.getUserByUsernameAndPassword(username,password);
          List<User> users=  serverResponse.getList();
          if (users!=null) {
              session.setAttribute(ResponseCode.User.CURRENT_USER.getMessage(), users.get(0));
          }
            return serverResponse;
    }
    @RequestMapping(value = "/add.do",method = RequestMethod.POST)
    public ServerResponse add(User user){
      return service.addUser(user);
    }
    @RequestMapping(value = "/all.do",method = RequestMethod.GET)
    public ServerResponse all(HttpSession session,String username){
        return service.getUsers();
    }
    @RequestMapping(value = "/getone.do",method = RequestMethod.GET)
    public ServerResponse getOne(HttpSession session,String username){
        User user=(User)   session.getAttribute(ResponseCode.User.CURRENT_USER.getMessage());
       if (user==null){
           return ServerResponse.serverError("未登录！");
       }
       return service.getUserByUsername(username);
    }
}
