package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntradaDeDatosYManejoDeStrings {
  public static void main(String[] args) {
    transformarTextoT9("ut1pd6\\src\\main\\java\\com\\example\\entrada2.txt");
    transformarT9Texto("ut1pd6\\src\\main\\java\\com\\example\\entrada2.txt");
  }

  public static void transformarTextoT9(String rutaArchivo){
    try {
      List<String> st = leerArchivo(rutaArchivo);
      for (String line: st){
        StringBuilder text = new StringBuilder();
        for (char c: line.toCharArray()){
          text.append(mapToT9(String.valueOf(c)));
        }
        System.out.println(text);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void transformarT9Texto(String rutaArchivo){
    try {
      List<String> st = leerArchivo(rutaArchivo);
      for (String line: st){
        StringBuilder reversed = new StringBuilder(line);
        reversed = reversed.reverse();
        StringBuilder text = new StringBuilder();
        for (char c: reversed.toString().toCharArray()){
          text.append(mapToT9(String.valueOf(c)));
        }
        System.out.println(text);
      }


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String mapToT9(String letter){
    HashMap<String, String> t9 = new HashMap<String, String>();
    t9.put(" ","0");
    t9.put(".","1");
    t9.put("A","2");
    t9.put("B","22");
    t9.put("C","222");
    t9.put("D","3");
    t9.put("E","33");
    t9.put("F","33");
    t9.put("G","4");
    t9.put("H","44");
    t9.put("I","444");
    t9.put("J","5");
    t9.put("K","55");
    t9.put("L","555");
    t9.put("M","6");
    t9.put("N","66");
    t9.put("O","666");
    t9.put("P","7");
    t9.put("Q","77");
    t9.put("R","777");
    t9.put("S","7777");
    t9.put("T","8");
    t9.put("U","88");
    t9.put("V","888");
    t9.put("W","9");
    t9.put("X","99");
    t9.put("Y","999");
    t9.put("Z","9999");
    return t9.get(letter.toUpperCase());
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
