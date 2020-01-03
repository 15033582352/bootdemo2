package com.neuedu.common;

import java.util.List;

public class ServerResponse<T>{
    private Integer code;
    private String message;
    private List<T> list;

    public ServerResponse(){

    }

    public ServerResponse(Integer code){
      this.code=code;
  }
    public ServerResponse(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    public ServerResponse(Integer code,List<T> list){
        this.list=list;
        this.code=code;
    }
    public ServerResponse(Integer code,String message,List<T> list){
        this.list=list;
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", list=" + list +
                '}';
    }

    public static ServerResponse serverSuccess(){
        return new ServerResponse(ResponseCode.Code.SUCCESS.getCode());
    }
    public static ServerResponse serverSuccess(String message){
        return new ServerResponse(ResponseCode.Code.SUCCESS.getCode(),message);
    }
    public static<T> ServerResponse serverSuccess(String message,List<T> list ){
        return new ServerResponse(ResponseCode.Code.SUCCESS.getCode(),message,list);
    }
    public static<T> ServerResponse serverSuccess(List<T> list ){
        return new ServerResponse(ResponseCode.Code.SUCCESS.getCode(),list);
    }
    public static ServerResponse serverError(){
        return new ServerResponse(ResponseCode.Code.ERROR.getCode());
    }
    public static ServerResponse serverError(String message){
        return new ServerResponse(ResponseCode.Code.ERROR.getCode(), message);
    }
    public static ServerResponse serverError(Integer code){
        return new ServerResponse(code);
    }
    public static ServerResponse serverError(Integer code,String message){
        return new ServerResponse(code, message);
    }




}
