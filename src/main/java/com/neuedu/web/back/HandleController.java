package com.neuedu.web.back;

import com.neuedu.common.ServerResponse;
import com.neuedu.pojo.Handle;
import com.neuedu.service.IHandleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class HandleController {
    @Resource
    private IHandleService service;
    @RequestMapping("/back/list.do" )
    public ServerResponse getList(){
        return service.getLists();
    }
    /*根据id查到要修改的品类*/
    @RequestMapping("/back/updateById.do" )
    public ServerResponse updateById(Integer id){
        return service.selectById(id);
    }
   /*根据id查到要修改的品类后，修改品类*/
    @RequestMapping("/back/doupdate.do" )
    public ServerResponse doupdate(Handle handle){
        return service.update(handle);
    }
    /*获取所选商品的子类商品*/

                     @RequestMapping("/back/getChildren.do" )
    public ServerResponse getChildren(Integer id){
        return service.getChildren(1);
    }
}
