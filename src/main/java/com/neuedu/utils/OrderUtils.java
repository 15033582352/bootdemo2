package com.neuedu.utils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class OrderUtils {
    public static  String str="asdodfodohfofjocdp54698494616496";
    public static Long toOrderNo(Date date,Integer id){
        Random random=new Random();
        return  UUID.fromString(random.nextInt( 100000)+id+"-8cf0-11bd-b23e-"+date.getTime()).timestamp();

    }
}
