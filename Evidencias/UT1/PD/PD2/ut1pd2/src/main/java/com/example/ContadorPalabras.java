package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.File;
import java.util.Scanner;


public class ContadorPalabras {
  public static int contarPalabras(String cadena) {
    boolean verificarPalabra = false;
    int contador = 0;
    cadena = cadena.trim();

    for (int i = 0; i < cadena.length(); i++) {
      if (cadena.charAt(i) == ' ') {
        if (verificarPalabra) {
          contador++;
        }
        verificarPalabra = false;
      } else if (Character.isLetter(cadena.charAt(i))) {
        verificarPalabra = true;
      }
    }
    if (verificarPalabra) {
      contador++;
    }
    return contador;
  }


  /*
    En este método comparmaos cada caracter de una frase con los caracteres determiandos en dos arrays, uno con las vocales y otro con
    las consonates. Si el caracter que se está evaluando es una vocal, vocales se incremanta en uno, en caso de ser una consonante,
    entonces la variable contsonante es la que se incrementa.
   */
  public void contarVocalesYConsonantes(String cadena) {
    ArrayList<String> Vocales = new ArrayList<String>(Arrays.asList("A", "E", "I", "O", "U", "Á", "É", "Í", "Ó", "Ú"));
    ArrayList<String> Consonantes = new ArrayList<>(Arrays.asList(
      "B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "Ñ", "P", "Q", "R", "S", "T", "V", "W", "X", "Y", "Z",
      "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "ñ", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"
    ));
    int consonantes = 0;
    int vocales = 0;

    cadena = cadena.toUpperCase();

    for (int i = 0; i < cadena.length(); i++) {
      char caracter = cadena.charAt(i);
      if (Vocales.contains(String.valueOf(caracter))) {
        vocales++;
      } else if (Consonantes.contains(String.valueOf(caracter))) {
        consonantes++;
      }
    }

    System.out.println("Número de vocales: " + vocales);
    System.out.println("Número de consonantes: " + consonantes);
  }

  /*
     a) Se agregan dos variables: -contadorCaracter: va contando la cantidad de caracteres hasta llegar a un espacio
                                -mayoresX: Cuenta la cantidad de palabras con caracteres mayores que x
  Se agrega contadorCaracter++ dentro del for, para que cuente cada caracter que pasa
  se reinicia el contador cuando se llega al espacio(despues de verificar si )

   */
  public int contarPalabrasSegunX(String cadena, int x) {
    boolean verificarPalabra = false;
    int contador = 0;
    int contadorCaracter = 0;
    int mayoresX = 0;
    cadena = cadena.trim();
    for (int i = 0; i < cadena.length(); i++) {
      if (cadena.charAt(i) == ' ') {
        contadorCaracter--; //restamos 1 cuando es un espacio

        if (contadorCaracter > x && verificarPalabra){ //al llegar al espacio se verifica que sea mayor que x, si lo es se suma uno en mayoresX
          mayoresX ++;
        }
        contadorCaracter = 0;  // sea o no sea mayor que x se elimina el contador para que vuelva a arrancar con la nueva palabra
        if (verificarPalabra) {
          contador++;
        }
        verificarPalabra = false;
      } else if (Character.isLetter(cadena.charAt(i))) {
        verificarPalabra = true;
      }

      contadorCaracter++;

    }

    if (verificarPalabra) {
      contador++;
    }

    System.out.println(mayoresX);
    return contador;
  }


  public static void main(String[] args) throws Exception {
    File doc = new File("C:\\Users\\Tadeo\\Desktop\\UT1_TA3_ARCHIVO_EJEMPLO.txt");
    Scanner obj = new Scanner(doc);
    int contador = 0;

    while (obj.hasNextLine()) {
      String txt = (obj.nextLine());
      System.out.println(txt);
      System.out.println(contador);
      contador ++;

      


      // por cada \n
    }
    // while (obj.hasNextLine()) {
    //     String vector[] = new String[contador];
    // for(int i=0; i<= contador; i++)
    // {
    //     vector [i] = obj.nextLine();
    //     System.out.println( vector [i]);

    // }

  }
}
