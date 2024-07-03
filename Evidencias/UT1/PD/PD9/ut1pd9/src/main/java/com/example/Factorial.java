package com.example;

public class Factorial {
  public static void main(String[] args) {
    int result = factorial(4);
    System.out.println(result);
}

  public static int factorial(int num){
    if (num == 0) {return 1;}
    return num * factorial(num - 1);
  }
}
