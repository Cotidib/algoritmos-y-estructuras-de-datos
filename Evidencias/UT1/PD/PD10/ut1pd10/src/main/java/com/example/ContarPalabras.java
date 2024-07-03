package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContarPalabras {
  public static void main(String[] args) {
    String[] palabras1 = new String[] {"hola", "mundo", "de", "los", "algoritmos"};

    String[] palabras2 = {"Hola", "mundo", "de", "la", "informática"};

    String[] resultado = contarPalabras(palabras1, palabras2);

    for (int i = 0; i < resultado.length; i++){
      System.out.println(resultado[i]);
    }

    try {
      List<String[]> cadenasArchivo = leerArchivo("ut1pd10\\src\\main\\java\\com\\example\\entrada.txt");
      // for(String s: cadenasArchivo.get(0)){
      //   System.out.println(s);
      // }
      // for(String s: cadenasArchivo.get(1)){
      //   System.out.println(s);
      // }

      //Obtener indices aleatorios dentro del rango de la cantidad de lineas que tiene el archivo
      int random1 = (int) (Math.random() * (cadenasArchivo.size() - 0));
      int random2 = (int) (Math.random() * (cadenasArchivo.size() - 0));

      String[] resultado2 = contarPalabras(cadenasArchivo.get(random1), cadenasArchivo.get(random2));
      for (int i = 0; i < resultado2.length; i++){
        System.out.println(resultado2[i]);
      }

    
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  
  // El metodo contarPalabras obtiene las palabras comunes entre dos arrays de strings, para ello
  // itera sobre el primer array y luego itera sobre el segundo, comparando cada una de las palabras del segudo array
  // con las palabras del primer array. Si las palabras coinciden, entonces esta es guardada en un tercero array donde se guardan todas las coincidencias.
  // El array que se obtiene como resultado es del mismo tamaño que el array más grande de los que se ingresan al metodo, 
  // de esta manera nos aseguramos que todas las concidencias posibles puedan ser almacenadas en dicho array.

  public static String[] contarPalabras(String[] palabras1, String[] palabras2){
    int tamañoArray = palabras1.length > palabras2.length ? palabras1.length : palabras2.length;
    String[] arResultado = new String[tamañoArray];

    int i=0;
    int j=0;

    while(i<palabras1.length){
      while(j<palabras2.length){
        if (palabras1[i].equals(palabras2[j])){
          arResultado[i] = palabras1[i];
        }
        j += 1;
      }
      j = 0;
      i += 1;
    }

    return arResultado;
  }

  public static List<String[]> leerArchivo(String path) throws FileNotFoundException, IOException{
    List<String[]> lista = new ArrayList<>();
    String[] linea;
    String cadena; 
    try {
      FileReader f = new FileReader(path);
      BufferedReader b = new BufferedReader(f); 
      while((cadena = b.readLine())!=null) { 
        // System.out.println(cadena); 
        linea = cadena.split(" ");
        lista.add(linea);
      } 
      b.close(); 

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return lista;
  }
}
