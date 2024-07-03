package com.example;

public class SomethingIsWrong {
public static void main(String[] args) {
  // Rectangle myRect; 
  //Rectangle cannot be resolved to a type
  //The local variable myRect may not have been initialized
  Rectangle myRect = new Rectangle();
  myRect.width = 40;
  myRect.height = 50;
  System.out.println("myRect's area is " + myRect.area());
  }

}