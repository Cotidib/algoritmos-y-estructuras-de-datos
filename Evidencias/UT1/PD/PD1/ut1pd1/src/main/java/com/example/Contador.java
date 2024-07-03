package com.example;

public class Contador {
  public final int MAX_CONT = 50;
  public int incremento = 1;
  public int contador = 1;

  public void mostrarContador(){
    System.out.println("WHILE");
    while(contador <= MAX_CONT){
      System.out.println(contador);
      contador = contador + incremento;
    }

    System.out.println("DO WHILE");
    do{
      System.out.println(contador);
      contador = contador + incremento;
    } while(contador <= MAX_CONT);

    System.out.println("FOR");
    for(int i=contador;i<=MAX_CONT;i++){
      System.out.println(contador);
      contador = contador + incremento;
    }
  }
}
