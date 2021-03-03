package com.andy.demo;

/**
 * 模拟龟兔赛跑
 */
public class RaceDemo2 implements  Runnable{

  private static String winner;


  @Override
  public void run() {
    for (int i = 0; i <= 1000; i++) {
      boolean flag=gameOver(i);
      if (flag){
        break;
      }
      if (Thread.currentThread().getName().equals("兔子")&&i%10==0){
        //兔子加速跑
        i=i+10;
        //兔子睡觉
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
      System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
    }
  }

  private boolean gameOver(int steps) {
    if (winner!=null){
      return true;
    }
    if (steps>=100){
      winner=Thread.currentThread().getName();
      System.out.println("winner is"+winner);
    }
    return false;
  }

  public static void main(String[] args) {
    RaceDemo2 race=new RaceDemo2();
    new Thread(race,"兔子").start();
    new Thread(race,"乌龟").start();
  }
}
