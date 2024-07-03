package com.example;

public class MetodosDeStringBuilder {
  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder();
    StringBuilder sb2 = new StringBuilder("hola");
    System.out.println(sb2.length());
    sb2.setLength(6);
    System.out.println(sb2.length());
    System.out.println(sb2.charAt(3));
    System.out.println(sb2.charAt(4));
    sb2.ensureCapacity(8);
    System.out.println(sb2.length());

    sb2.append("a");
    System.out.println(sb2);
    sb2.insert(1,"u");
    System.out.println(sb2);
    sb2.delete(2,3);
    System.out.println(sb2);
    sb2.deleteCharAt(0);
    System.out.println(sb2);
    sb2.reverse();
    System.out.println(sb2);

  }
}
