package com.example;

public class ContadorPalabras {
  
  public enum Vocales {
    A, E, I, O, U, Á, É, Í, Ó, Ú;
  }

  public enum Consonantes {
    B, C, D, F, G, H, J, K, L, M, N, Ñ, P, Q, R, S, T, V, W, X, Y, Z,
    b, c, d, f, g, h, j, k, l, m, n, ñ, p, q, r, s, t, v, w, x, y, z;
  }

  public void contarVocalesYConsonantes(String cadena) {

    int consonantes = 0;
    int vocales = 0;

    cadena = cadena.toUpperCase();

    for (int i = 0; i < cadena.length(); i++) {
      String caracter = Character.toString(cadena.charAt(i));
      for (Vocales v: Vocales.values()){
        if (v.name().equals(caracter)){
          vocales++;
        }
      }
      for (Consonantes c: Consonantes.values()){
        if (c.name().equals(caracter)){
          consonantes++;
        }
      }
    }

    System.out.println("Número de vocales: " + vocales);
    contar(Vocales.class, cadena);
    System.out.println("Número de consonantes: " + consonantes);
    contar(Consonantes.class, cadena);
  }

  // En este metodo intento unificar la logica dentro de contarVocalesYConsonantes para no repetir codigo
  public void contar (Class<? extends Enum> em, String cadena){
    int total = 0;
    cadena = cadena.toUpperCase();
    for (int i = 0; i < cadena.length(); i++) {
      String caracter = Character.toString(cadena.charAt(i));
      for (Enum e: em.getEnumConstants()){
        if (e.name().equals(caracter)){
          total++;
        }
      }
    }
    System.out.println(total);
  }

}