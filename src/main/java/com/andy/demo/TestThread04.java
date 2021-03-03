package com.andy.demo;

import javax.swing.*;

/**
 * 并发问题
 */
public class TestThread04 implements Runnable{

   private  int tickNums=10;

   public  void run() {
     while (true){
       if (tickNums<=0){
         break;
       }
       try {
         Thread.sleep(200);
       } catch (InterruptedException e) {
         e.printStackTrace();
       }
       System.out.println(Thread.currentThread().getName()+"--->拿到了第"+tickNums--+"票");
     }
   }

  public static void main(String[] args) {
    TestThread04 ticket=new TestThread04();
    new Thread(ticket,"小明").start();
    new Thread(ticket,"老师").start();
    new Thread(ticket,"黄牛党").start();
  }

}
