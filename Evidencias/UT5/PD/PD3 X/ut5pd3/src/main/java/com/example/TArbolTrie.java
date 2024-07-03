package com.example;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    public void imprimirIndice() {
        if (raiz != null) {
            raiz.imprimirIndice();
        }
    }

    @Override
    public int buscarCantComparaciones(String palabra) {
        if (raiz != null) {
           return raiz.buscarCantComparaciones(palabra);
        } else {
            return -1;
        }
    }

    public TNodoTrie buscarNodoTrie(String palabra) {
        if (raiz != null) {
           return raiz.buscarNodoTrie(palabra);
        } else {
            return null;
        }
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void indizarLibro(String archivoURL){
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        int contadorPaginas = 1;
        int contadorLineas = 0;
        String[] lineas = manejadorArchivos.leerArchivo(archivoURL);
        for (String linea : lineas){
            if(contadorLineas == 50){
                contadorLineas = 0;
                contadorPaginas += 1;
            }

            linea = linea.toLowerCase().replaceAll("[^a-z\\s]","");
            String[] palabras = linea.split(" ");
            for (String palabra : palabras){
                TNodoTrie nodo = raiz.buscarNodoTrie(palabra);
                if (nodo != null){
                    nodo.indizar(contadorPaginas);
                }
            }
            contadorLineas += 1;
        }
    }
    
    
}
