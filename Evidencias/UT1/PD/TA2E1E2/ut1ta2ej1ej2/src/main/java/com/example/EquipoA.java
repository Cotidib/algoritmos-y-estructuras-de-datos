package com.example;

public class EquipoA {
  public static int factorial(int num) {
    int numero = num;
    int factor = 1;

    if (num == 0) {
        return 1;
    }
    else if (num <0) {
        System.out.println("El factorial de "+ num +" no existe");
        return 0;
    }
    else {
        for (int i = 1; i <= numero; i++) {
            factor *= i;

        }
    }
    return factor;
  }
}
