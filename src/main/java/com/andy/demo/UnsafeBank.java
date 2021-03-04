package com.andy.demo;

public class UnsafeBank {
}

class Account{
  int money;
  String name;

  public Account(int money, String name) {
    this.money = money;
    this.name = name;
  }

  class Drawing extends Thread{
    Account account;
    int drawingMoney;
    String name;

    public Drawing(Account account, int drawingMoney, String name) {
      super(name);
      this.account = account;
      this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
      super.run();
    }
  }

}
