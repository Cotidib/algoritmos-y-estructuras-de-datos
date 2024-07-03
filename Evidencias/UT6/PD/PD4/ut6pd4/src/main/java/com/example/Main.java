package com.example;

public class Main {
    public static void main(String[] args) {

        // Para implementar un programa que obtenga las frecuencias de ocurrencias de las palabras de un libro 
        // de manera eficiente en Java, una de las mejores opciones es utilizar la clase HashMap, ya que el tiempo
        // de ejecucion para las operaciones de busqueda y de insercion es de tiempo constante. 
        // Sin embargo, si se quiere obtener las frecuencias de ocurrencias de las palabras de un libro de manera ordenada
        // por frecuencia, se puede utilizar la clase List, ya que se pueden ordenar sus elementos de manera eficiente con
        // la implementacion de sort de java

        Libro libro = new Libro();
        libro.cargarLibro("ut6pd4\\src\\main\\java\\com\\example\\libro.txt");
        // System.out.println(libro.obtenerFrecuencia("was"));
        libro.top10();
        
    }
}