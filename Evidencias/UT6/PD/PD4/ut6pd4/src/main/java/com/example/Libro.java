package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Libro {
    TreeMap<String, Integer> palabras = new TreeMap<String, Integer>();

    public void cargarLibro(String archivo){
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = manejadorArchivos.leerArchivo(archivo);
        for (String linea : lineas){
            linea = linea.toLowerCase().replaceAll("[^a-z\\s]","");
            String[] palabras = linea.split(" ");
            for (String palabra : palabras){
                    this.agregarPalabra(palabra);
            }
        }
    }

    private void agregarPalabra(String palabra){
        if (palabras.get(palabra) == null){
            palabras.put(palabra, 1);
        } else {
            palabras.put(palabra, palabras.get(palabra) + 1);
        }
    }

    public int obtenerFrecuencia(String palabra){
        return palabras.get(palabra);
    }

    public void top10(){
        List<Map.Entry<String, Integer>> list = new ArrayList<>(palabras.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        int contador = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if(contador > 10){
                return;
            }
            System.out.println(entry.getKey() + " : " + entry.getValue());
            contador++;
        }
    }
}
