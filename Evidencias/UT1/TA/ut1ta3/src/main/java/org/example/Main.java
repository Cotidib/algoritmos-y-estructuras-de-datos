package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {

    ContadorPalabras cont = new ContadorPalabras();
    System.out.println(cont.contarPalabras("Si piensas que tu profesor es exigente,... espera a conocer a tu jefe !"));

    cont.contarVocalesYConsonantes("Si piensas que tu profesor es exigente,... espera a conocer a tu jefe !");

    System.out.println(cont.contarPalabrasSegunX("Si piensas que tu profesor es exigente,... espera a conocer a tu jefe 666666 !", 4));


  }
}
