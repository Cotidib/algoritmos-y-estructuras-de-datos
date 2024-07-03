package org.example;

import java.util.ArrayList;
import java.util.List;

public class ContadorPalabras {

  public int contarPalabras(String cadena) {
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

  List<String> palabrasComunes(String[] palabras1, String[] palabras2){

    List<String> arResultado = new ArrayList<>();

    for (int i = 0; i < palabras1.length; i++){

      for (int j = 0; j < palabras2.length; j++){

        if ( palabras1[i].equals(palabras2[j] )){

          arResultado.add(palabras1[i]);

        }

      }

    }

    return arResultado;

  }

}
