package com.neuedu.vo;

public interface demo {
    static int a(int x){
     return a(x);
    }
    
    //饿汉式
   /*  private static demo dem=new demo();
     private  demo(){};
     public  static demo getInstance(){

         return  dem;
     }*/
   //懒汉式+doublecheck+volatile
  /* private volatile static demo d=null;
   private demo(){};
   public static demo getInstance(){
       if (d==null){
           synchronized (demo.class){
          if (d==null){
              d=new demo();
          }
           }
       }
       return d;
   }*/
   /* public static void main(String[] args) {

    }*/
}
