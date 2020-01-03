package com.neuedu.vo;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@WebServlet("/index")
public class test extends HttpServlet {
    static  boolean flag;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.print("<html><head></head><body><div style='width:100px;height:100px; background:red'></div></body></html>");
    }
    public static void main(String[] args) {
        String s="aaa";
        char[] c1=  s.toCharArray();
        int index=c1.length-1;

        int[] a=new int[3];
             a=new int[]{1,2};
        List list=new ArrayList();
        list.add(a);
        System.out.println(list.size());
  /* StringBuilder builder=new StringBuilder("01");
   String before=  builder.toString();
        StringBuilder after=builder.reverse();
   String after1=     after.toString();
   if (before.equals(after1)){
       System.out.println(true);
   }else{
       System.out.println(false);
   }*/

    }
    //实现多线程的几种方式
    /*
    * 1.继承Thread
    * 2.实现runnable
    * 3.线程池
    * sleep 线程休眠 在一定时间内，该线程放弃对cpu的抢占
    * */

/*    public static void main(String[] args) {
        int[] a={1,5,4,10,78,12,100,50};
        int temp;
        for (int i=0;i<a.length-1;i++){
            //
            for (int j=i+1;j<a.length;j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int b:
                a ) {
            System.out.println(b);
        }
       */
/* Thread t1=new MyThead();
        t1.start();
        for (int i=0;i<100;i++){

                System.out.println(i);
        }*//**//*
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println("实现runnable的线程-----"+i);
                }
            }
        });*//*
    }*/
}
