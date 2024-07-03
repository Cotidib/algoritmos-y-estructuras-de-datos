package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContadorIf {
  public static void main(String[] args) {
    String rutaArchivo = "ut2pd1\\src\\main\\resources\\numeros.txt";
    try {
      // List<String> st = leerArchivo(rutaArchivo);
      String[] st = leerArchivo2(rutaArchivo);
      
      // miFuncion(Integer.parseInt(st.get(0)), st);
      miFuncion2(Integer.parseInt(st[0]), st);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void miFuncion2(int N, String[] arreglo){
    System.out.println("Valor de N:");
    System.out.println(N);
    int contador = 0;
    for (int i = 0; i < N-1; i++){
      for (int j = N; j > i+1; j--){
        if(Integer.parseInt(arreglo[j]) < Integer.parseInt(arreglo[j-1])){
          // Intercambia(arreglo[j], arreglo[j-1])
          contador += 1;
        }
      }
    }
    System.out.println("Valor de contador:");
    System.out.println(contador);
    System.out.println("Valor de arreglo[1]:");
    System.out.println(arreglo[1]);
    System.out.println("Valor de arreglo[N]:");
    System.out.println(arreglo[N]);
  }

  public static String[] leerArchivo2(String path) throws FileNotFoundException, IOException{
    int indexUltimo = 0;
    int capacidad = 1;
    String[] lineas = new String[capacidad];
    String cadena; 
    try {
      FileReader f = new FileReader(path);
      BufferedReader b = new BufferedReader(f); 
      while((cadena = b.readLine())!=null) { 
        if (indexUltimo == capacidad) {
          capacidad += 1;
          String[] lineasTemp = new String[capacidad];
          for (int i = 0; i<indexUltimo; i++){
            // System.out.println(lineas[i]);
            lineasTemp[i] = lineas[i];
          }
          lineas = lineasTemp;
        }
        lineas[indexUltimo] = cadena;
        indexUltimo++;
      } 
      b.close(); 

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return lineas;
  }

  // EL METODO MIFUNCION UTILIZA List<String> COMO TIPO DE DATO DE ARREGLO
  // ESCENCIALMENTE SE COMPORTA DE LA MISMA MANERA QUE MIFUNCION2
  public static void miFuncion(int N, List<String> arreglo){
    System.out.println(N);
    int contador = 0;
    for (int i = 0; i < N-1; i++){
      for (int j = N; j > i+1; j--){
        if(Integer.parseInt(arreglo.get(j)) < Integer.parseInt(arreglo.get(j-1))){
          // System.out.println("Intercambia(arreglo[j], arreglo[j-1])");
          contador += 1;
        }
      }
    }
    System.out.println(contador);
    System.out.println(arreglo.get(0));
    System.out.println(arreglo.get(N));
  }

  // EL METODO LEERARCHIVO UTILIZA List<String> COMO TIPO DE DATO DE SALIDA
  // ESCENCIALMENTE SE COMPORTA DE LA MISMA MANERA QUE LEERARCHIVO2
  public static List<String> leerArchivo(String path) throws FileNotFoundException, IOException{
    List<String> linea = new ArrayList<>();
    String cadena; 
    try {
      FileReader f = new FileReader(path);
      BufferedReader b = new BufferedReader(f); 
      while((cadena = b.readLine())!=null) { 
        // System.out.println(cadena); 
        linea.add(cadena);
      } 
      b.close(); 

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return linea;
  }

  
}
