package com.example;

public class EquipoB {

  public static boolean isPrime(long n) {
    boolean prime = true;
    for (long i = 3; i <= Math.sqrt(n); i += 2)
    if (n % i == 0) {
    prime = false;
    break;
    }
    if (( n%2 !=0 && prime && n > 2) || n == 2) {
    return true;
    } else {
    return false;
    }
  }

  public int calcular(int numero){
    int total = 0;
    int i=0;
    if(isPrime(numero)){
      // sumar los pares hasta numero
      while (i<numero){
        if(i%2 == 0){
          total +=i;
        }
        i++;
      }
    } else {
        // sumar los impares hasta numero
        while (i<numero){
        if(i%2 != 0){
          total +=i;
        }
        i++;
      }
    }
    System.out.println(total);
    return total;
  }


}