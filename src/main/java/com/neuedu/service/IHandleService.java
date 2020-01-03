package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Handle;

public interface IHandleService {
    ServerResponse getLists();
    ServerResponse selectById(Integer id);
    ServerResponse update(Handle handle);
   ServerResponse  getChildren(Integer id);
    Handle getHandleByName(String name);
    Handle getHandleById(Integer id);
}
