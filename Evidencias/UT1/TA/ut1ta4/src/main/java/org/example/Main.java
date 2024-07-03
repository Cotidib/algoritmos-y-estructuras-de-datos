package org.example;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {

    ContadorPalabras cont = new ContadorPalabras();

    String[] palabras1 = new String[] {"hola", "mundo", "de", "los", "algoritmos"};

    String[] palabras2 = {"Hola", "mundo", "de", "la", "informática"};

    List<String> variable = cont.palabrasComunes(palabras1, palabras2);

    for (int i = 0; i < variable.size(); i++){

      System.out.println(variable.get(i));

    }

  }
}
