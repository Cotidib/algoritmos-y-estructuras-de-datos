package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EntradaDeDatos {

  public static void main(String[] args) {
    leerEntradaArchivo("ut1pd6\\src\\main\\java\\com\\example\\entrada.txt");
    leerEntradaStdin();
  }

  public static void leerEntradaArchivo(String ruta){
    try {
      List<String> entradas = leerArchivo(ruta);
      String enteroEntrada = entradas.get(0);
      int entero = Integer.parseInt(enteroEntrada);
      String flotanteEntrada = entradas.get(1);
      float flotante = Float.parseFloat(flotanteEntrada);
      String nombre = entradas.get(2);
      //TODO No acepta ceros
      System.out.println("El entero leído es: " + enteroEntrada);
      System.out.println("El número de punto flotante es: " + flotanteEntrada);
      System.out.println("La cadena leída es " + nombre);
      System.out.println("¡Hola " + nombre + "! La suma de " + enteroEntrada + " y " + flotanteEntrada + " es " + (entero+flotante));
      System.out.println("La división entera de " + flotanteEntrada + " y " + enteroEntrada + " es " + (int)(flotante / entero) + " y su resto es " + String.format("%.2f", flotante % entero));


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void leerEntradaStdin(){
    String radioEntrada = System.console().readLine();
    float radio = Float.parseFloat(radioEntrada);

    double area = Math.PI * radio * radio;
    double perimetro = Math.PI * radio * 2;

    System.out.println("El radio es: " + radioEntrada);
    System.out.println("El area es: " + String.format("%.2f",area) + " y el perimetro es: " + String.format("%.2f",perimetro));
  }

  public static List<String> leerArchivo(String path) throws FileNotFoundException, IOException{
    List<String> rows = new ArrayList<>();
    String cadena; 
    try {
      FileReader f = new FileReader(path);
      BufferedReader b = new BufferedReader(f); 
      while((cadena = b.readLine())!=null) { 
        // System.out.println(cadena); 
        rows.add(cadena);
      } 
      b.close(); 

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return rows;
  }

  
}
