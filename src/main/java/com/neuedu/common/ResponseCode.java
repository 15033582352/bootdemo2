package com.neuedu.common;


public class ResponseCode {
    public enum Code{
    SUCCESS(200,"返回成功的状态码"),ERROR(100,"失败"),MANAGER(0,"管理员");
    private Integer code;
    private String message;

     private Code(Integer code,String message){
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
    }

    public enum User{
        CURRENT_USER(300,"CURRENT_USER");
        private Integer code;
        private String message;

        private User(Integer code,String message){
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
    }
    }
