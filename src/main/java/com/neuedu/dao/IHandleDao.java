package com.neuedu.dao;



import com.neuedu.pojo.Handle;

import java.util.List;

public interface IHandleDao {
    List<Handle> getLists();
    Handle getHandleByid(Integer id);
     int doupdate(Handle handle);
     List<Handle> getChildren(Integer id);
    Handle getHandleByName(String name);
}
