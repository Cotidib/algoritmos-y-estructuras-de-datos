package com.example;

public class IsPrime {

  public static void main(String[] args) {
    int resultado1 = calcular(32);
    System.out.println(resultado1);

    int resultado2 = calcular2(32);
    System.out.println(resultado2);
  }

  public static int calcular(int numero){
    int total = 0;
    int i=0;
    if(esPrimo(numero)){
      while (i<numero){
        if(i%2 == 0){
          total +=i;
        }
        i++;
      }
    } else {
        while (i<numero){
        if(i%2 != 0){
          total +=i;
        }
        i++;
      }
    }
    return total;
  }

  public static int calcular2(int numero){
    boolean par = esPrimo(numero);
    int total = 0;
    
    int i=0;
    while(i<numero){
      if (par ? esPar(i): esImpar(i)){
        total +=i;
      }
      i++;
    }
    return total;
  }

  public static boolean esPrimo(long n) {
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

  public static boolean esPar(int numero){
    return numero%2 == 0;
  }

  public static boolean esImpar(int numero){
    return numero%2 != 0;
  }

}
