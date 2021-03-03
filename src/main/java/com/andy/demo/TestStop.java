package com.andy.demo;

public class TestStop implements  Runnable{
  private  boolean flag=true;

  @Override
  public void run() {
    int i=0;
    while (flag){
      System.out.println("run、、、、、、Thread"+i++);
    }
  }

  public void stop(){
    this.flag=false;
  }

  public static void main(String[] args) {
    TestStop testStop=new TestStop();
    new Thread(testStop).start();

    for (int i = 0; i < 100; i++) {
      if (i==90){
        testStop.stop();
        System.out.println("线程该停止了");
      }

    }
  }
}
