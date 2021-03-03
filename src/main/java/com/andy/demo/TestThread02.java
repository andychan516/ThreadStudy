package com.andy.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread02 extends Thread{

  private String url;
  private String name;

  public TestThread02(String url, String name) {
    this.url = url;
    this.name = name;
  }

  @Override
  public void run() {
    webDownloader webDownloader=new webDownloader();
    webDownloader.downloader(url,name);
    System.out.println("下载了文件："+name);
  }

  public static void main(String[] args) {
    TestThread02 t1=new TestThread02("http://img.netbian.com/file/2020/0904/de2f77ed1090735b441ba5e4c2b460ca.jpg","andy1.jpg");
    TestThread02 t2=new TestThread02("http://img.netbian.com/file/2020/0904/de2f77ed1090735b441ba5e4c2b460ca.jpg","andy2.jpg");
    TestThread02 t3=new TestThread02("http://img.netbian.com/file/2020/0904/de2f77ed1090735b441ba5e4c2b460ca.jpg","andy3.jpg");
    t1.start();
    t2.start();
    t3.start();
  }

  class webDownloader{
    public void downloader(String url, String name){
      try {
        FileUtils.copyURLToFile(new URL(url),new File(name));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
