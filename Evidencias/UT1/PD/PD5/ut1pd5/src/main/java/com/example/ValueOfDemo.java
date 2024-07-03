package com.example;

public class ValueOfDemo {
  public static void main(String[] args) {
    // this program requires two
    // arguments on the command line
    String firstInput = System.console().readLine();
    String secondInput = System.console().readLine();

    if (firstInput != null && secondInput != null) {
      float a = (Float.valueOf(firstInput)).floatValue(); 
      float b = (Float.valueOf(secondInput)).floatValue();
      // Si los argumentos fueran enteros positivos:
      // int a2 = (Integer.valueOf(firstInput)).intValue();
      // int b2 = (Integer.valueOf(secondInput)).intValue();

      System.out.println("a + b = " +
      (a + b));
      System.out.println("a - b = " +
      (a - b));
      System.out.println("a * b = " +
      (a * b));
      System.out.println("a / b = " +
      (a / b));
      System.out.println("a % b = " +
      (a % b));
    } else {
      System.out.println("This program " +
      "requires two command-line arguments.");
    }
  }
}


//Salida con 13.4 y 66.1:
/* a + b = 79.5
a - b = -52.699997
a * b = 885.7399
a / b = 0.20272315
a % b = 13.4 */
