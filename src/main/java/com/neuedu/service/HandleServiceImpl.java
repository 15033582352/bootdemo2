package com.neuedu.service;

import com.neuedu.common.ServerResponse;
import com.neuedu.dao.IHandleDao;
import com.neuedu.pojo.Handle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HandleServiceImpl implements IHandleService {
    @Resource
    private IHandleDao handleDao;
    @Override
    public ServerResponse getLists() {
        List<Handle> lists = handleDao.getLists();
        if (lists == null) {
            return ServerResponse.serverError("发生未知错误，请返回");
        }
        return ServerResponse.serverSuccess("查询成功", lists);
    }

    @Override
    public ServerResponse selectById(Integer id) {
        if (id==null || "".equals(id)){
            return ServerResponse.serverError("id值为空");
        }
      Handle handle=  handleDao.getHandleByid(id);
        if (handle==null){
            return ServerResponse.serverError("根据id查找出来的用户我为空");
        }
        return ServerResponse.serverSuccess("查询用户成功", Arrays.asList(handle));
    }

    @Override
    public ServerResponse update(Handle handle) {
        if (handle.getId()==null||"".equals(handle.getId())){
            return ServerResponse.serverError("id 空" );
        }
        if (handle.getName()==null||"".equals(handle.getName())){
            return ServerResponse.serverError("name 空" );
        }
        if (handle.getParentId()==null){
            handle.setParentId(1);
        }
       int result= handleDao.doupdate(handle);
        if (result>0){
            return ServerResponse.serverSuccess("修改成功");
        }else {
            return ServerResponse.serverError("修改失败" );
        }
    }

    @Override
    public ServerResponse getChildren(Integer id) {
        if (id==null || "".equals(id)){
            return ServerResponse.serverError("id值为空");
        }

        List<Handle> handles= handleDao.getChildren(id);
        return ServerResponse.serverSuccess("查询成功",handles);
    }

    @Override
    public Handle getHandleByName(String name) {
        return handleDao.getHandleByName(name);
    }

    @Override
    public Handle getHandleById(Integer id) {
        return handleDao.getHandleByid(id);
    }
}