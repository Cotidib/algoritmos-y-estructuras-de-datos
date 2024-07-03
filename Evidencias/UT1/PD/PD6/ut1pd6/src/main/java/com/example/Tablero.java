package com.example;

public class Tablero {

  public static void main(String[] args) {
    Tablero.imprimirTablero(2, 2);
    Tablero.imprimirTablero(5, 3);
  }

  public static void imprimirTablero(int largo, int ancho){
    for (int l = 0 ; l < largo ; l++){
      StringBuilder fila = new StringBuilder();
      for (int a = 0 ; a < ancho; a++){
        fila.append("#");
      }
      System.out.println(fila);
    }

  }
}
