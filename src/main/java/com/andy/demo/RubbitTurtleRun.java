package com.andy.demo;

public class RubbitTurtleRun extends Thread{

  //设置长度为1000m
  private int distance = 1000;

  //设置兔子和乌龟每次走的路长度
  int rubbitNum = 40;
  int turtleNum = 20;

  //设置兔子和乌龟已经走的路长度
  int rubbitDistance = 0;
  int turtleDistance = 0;

  boolean flag = true;
  @Override
  public void run() {
    String name = Thread.currentThread().getName();

    while (flag){

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if (name.equals("兔子")){

        rubbitDistance = rubbitDistance+rubbitNum;
        System.out.println(name+"我已经跑了"+rubbitDistance+"米");
        //兔子中间休息了
        if ((rubbitDistance%200==0) && (rubbitDistance<distance)){
          System.out.println(name+"好累啊，已经跑了"+rubbitDistance+"米，乌龟还在后面，先休息一会吧");
          try {
            //兔子休息
            sleep(650);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (rubbitDistance == distance){
          System.out.println("=======兔子赢了============");
          flag = false;
          break;
        }
      }

      //乌龟不休息
      if (name.equals("乌龟")){
        turtleDistance = turtleDistance+turtleNum;
        System.out.println(name+"我已经跑了"+turtleDistance+"米");
        if (turtleDistance == distance){
          System.out.println("======乌龟赢了==========");
          flag = false;
          break;
        }
      }

    }
  }


  public static void main(String[] args) {
    RubbitTurtleRun rubbit = new RubbitTurtleRun();
    RubbitTurtleRun turtle = new RubbitTurtleRun();
    rubbit.setName("兔子");
    turtle.setName("乌龟");

    rubbit.start();
    turtle.start();

  }
}

