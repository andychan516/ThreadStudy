package com.andy.demo;

public class UnsafeBuyTicket {

  public static void main(String[] args) {
    BuyTicket station=new BuyTicket();
    new Thread(station,"苦逼的我").start();
    new Thread(station,"牛逼的你们").start();
    new Thread(station,"可恶的黄牛党").start();
  }

}

class BuyTicket implements Runnable{

  private int ticketNums=10;
  boolean flag=true;

  @Override
  public void run() {
    while (flag){
      try {
        buy();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void buy() throws InterruptedException {
    if (ticketNums<=0){
      flag=false;
      return;
    }

    Thread.sleep(1000);
    System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
  }

}
