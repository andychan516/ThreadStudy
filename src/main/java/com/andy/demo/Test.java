package com.andy.demo;

public class Test {
  static boolean flag=true;
  public static void main(String[] args) {

    while (flag){
      for (int i = 0; i <=10; i++) {
        System.out.println(i);
        if (i==3){

          System.out.println("break");
          flag=false;
          break;
        }

      }
      if (flag==false){
        break;
      }
      System.out.println("end");
    }
  }
}
