package com.andy.demo;

/**
 * 静态代理模式
 */
public class StaticProxy {
  public static void main(String[] args) {
     MarryCompany marryCompany=new MarryCompany(new You());
     marryCompany.happyMarry();
  }
}

interface Marry{
  void happyMarry();
}

class You implements Marry{

  @Override
  public void happyMarry() {
    System.out.println("你结婚了");
  }
}

/**
 * 婚庆公司
 */
class MarryCompany implements Marry {

  private Marry target;

  public MarryCompany(Marry target) {
    this.target = target;
  }

  @Override
  public void happyMarry() {
    before();
    target.happyMarry();
    after();
  }

  public void before(){
    System.out.println("结婚前，布置现场，策划活动");
  }

  public void after(){
    System.out.println("结婚后，清扫现场，收取尾款");
  }
}
