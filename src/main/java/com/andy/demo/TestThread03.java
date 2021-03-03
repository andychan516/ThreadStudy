package com.andy.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread03 implements Runnable{


  public static void main(String[] args) {
    TestThread03 testThread03=new TestThread03();
    new Thread(testThread03).start();;

    for (int i = 0; i < 20; i++) {
      System.out.println("我在学习多线程--"+i);
    }
  }

  @Override
  public void run() {
      for (int i = 0; i < 20; i++) {
        System.out.println("我在看代码-------"+i);
      }
   }
}
