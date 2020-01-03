package com.neuedu.vo;

import java.util.LinkedList;

public class single {
    //创建一个single对象
    private  static single single=new single();
   //通过private修饰构造方法
    private single(){

    }
    public static single getInstance(){
        return single;
    }

}
