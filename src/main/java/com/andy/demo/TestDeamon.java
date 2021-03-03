package com.andy.demo;

/**
 * 守护线程
 */
public class TestDeamon {

  public static void main(String[] args) {
    God god=new God();
    Person you=new Person();

    Thread thread=new Thread(god);
    thread.setDaemon(true);
    thread.start();
    new Thread(you).start();
  }



}

class God implements Runnable{
  @Override
  public void run() {
    while (true){
      System.out.println("上帝保佑你");
    }
  }
}

class Person implements Runnable{

  @Override
  public void run() {
    for (int i = 1; i <=36500; i++) {
      System.out.println("你一生都开心迪活着"+"第"+i+"天");
    }
  }
}
