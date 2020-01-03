package com.neuedu.vo;

public class MyThead extends Thread {
    @Override
    public void run() {
        for (int i=0;i<100;i++){

                System.out.println("继承Thread的线程-----"+i);


        }
    }
}
