package com.neuedu.vo;

public class MyRunabl implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<100;i++){

            System.out.println("实现runnable的线程-----"+i);


        }
    }
}
