package com.andy.demo;

/**
 * 模拟龟兔赛跑
 */
public class Race implements Runnable{

   private static String winner;

   private int rabbitStep=2;

   private int turtleStep=1;

   private int race=100;

   int rabbitDistance = 0;

   int turtleDistance = 0;

   boolean flag=true;

   public  void run() {
     while (flag) {
        if (Thread.currentThread().getName().equals("兔子")){
          rabbitDistance=rabbitDistance+rabbitStep;
          System.out.println(Thread.currentThread().getName()+"跑了"+rabbitDistance+"步");

          if (rabbitDistance==race){
            System.out.println("兔子赢了");
            System.out.println("--------------------");
            System.out.println("兔子"+flag);
            break;
          }
        }

       if (Thread.currentThread().getName().equals("乌龟")){
         turtleDistance=turtleDistance+turtleStep;
         System.out.println(Thread.currentThread().getName()+"跑了"+turtleDistance+"步");

         if (turtleDistance==race){
           System.out.println("乌龟赢了");
           System.out.println("--------------------");
           System.out.println("乌龟"+flag);
           flag = false;
           break;
         }
       }

     }
   }

  private boolean gameOver(int distance) {
    if (winner!=null){
      return true;
    }
    if (distance == race){
      winner=Thread.currentThread().getName();
      System.out.println("winner is "+winner);
      return  true;
    }
    return false;
  }

  public static void main(String[] args) {
    Race rabbitRace=new Race();
    Race turtleRace=new Race();

    new Thread(rabbitRace,"乌龟").start();
    new Thread(turtleRace,"兔子").start();
  }

}
