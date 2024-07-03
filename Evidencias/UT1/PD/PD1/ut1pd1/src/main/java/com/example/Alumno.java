package com.example;

public class Alumno {
  private String nombre;
  
  public Alumno () {
    nombre = null;
  }

  public String getNombreAdmiracion() {
    return nombre.concat("!");
  }
  public static void main (String[] args) {
    Alumno alumno = new Alumno();
    System.out.println(alumno.getNombreAdmiracion());
  }
  // }    Este corchete sobra

  public static int recorrer (String cadena) {
    int res = 0;
    for (int i = 1; i < cadena.length(); i++) {     //Arreglado el error de index out of range
      if (cadena.charAt(i) != ' ') {
      res++;
      }
    }
    return res;
  }

  public static int getValor() {
    int vector[] = { 6, 16, 26,36,46,56,66,76 };
    int idx = 7;
    return vector[idx];
  }

  public static char getPrimerCaracter(String palabra) {
    // String string[] = new String[5];     //No es necesario
    return (palabra.charAt(0));       //Cambie string por palabra y el indice lo puse en 0
  }

  public static String paraAString(int a) {
  Object x1 = String.valueOf(a); //Cambie new Integer(a) por String.valueOf
  return (String) (x1) ;
  }

} //Faltaba un corchete para cerrar la clase
