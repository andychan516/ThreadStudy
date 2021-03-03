package com.andy.demo;

public class TestYield {

  public static void main(String[] args) {
    MyYield myYield=new MyYield();
    new Thread(myYield,"andy").start();
    new Thread(myYield,"jack").start();
  }


}

class  MyYield implements Runnable{
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName()+"线程开始执行");
    Thread.yield();
    System.out.println(Thread.currentThread().getName()+"线程开始执行");
  }
}
