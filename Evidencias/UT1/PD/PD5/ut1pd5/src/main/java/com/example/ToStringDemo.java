package com.example;

public class ToStringDemo {
  public static void main(String[] args) {
    double d = 888.51;
    String s = Double.toString(d);
    int dot = s.indexOf('.');
    System.out.println(dot + " digits " + "before decimal point.");
    System.out.println( (s.length() - dot - 1) + " digits after decimal point.");
  }
}

// La salida es:
// 3 digits before decimal point.
// 2 digits after decimal point.

// Para imprimir la primera linea, se busca el indice en el cual se encuentra el punto. Se busca la posicion del punto adentro de un string.
// Sabiendo la posicion del punto, la cantidad de elementos antes del punto es la cantidad de digitos antes del punto decimal

// Para imprimir la segunda linea, sabiendo la posicion del punto en el string y el largo del string, 
// haciendo la diferencia entre el largo y el indice del punto, obtenemos los digitos que estan despues del punto. 
// Como no queremos incluir el punto como un digito más, se resta 1