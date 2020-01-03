package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IUserService {
    ServerResponse getUsers();
    ServerResponse getUserByUsernameAndPassword(String username,String password);
    ServerResponse addUser(User user);
    ServerResponse getUserByUsername(String username);
    ServerResponse check_username(String username);
    ServerResponse getOneByRole(String username,Integer role);
    ServerResponse updateUser(String username,String password);
}
