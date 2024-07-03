package com.example;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }
    
    private TNodoTrie buscarNodoTrie(String unaPalabra) {
        char[] unaPalabraArray = unaPalabra.toCharArray();
        TNodoTrie nodoActual = this;
        for (int c = 0; c < unaPalabraArray.length; c++){
            TNodoTrie unHijo = nodoActual.obtenerHijo(unaPalabraArray[c]);
            if(unHijo == null){
                return null;
            } else {
                nodoActual = unHijo;
            }
        }
        if(nodoActual.esPalabra){
            return nodoActual;
        } else {
            return null;
        }
    }

    public TNodoTrie obtenerHijo(char caracter){
        char caracterMin = Character.toLowerCase(caracter);
        int posicion = caracterMin - 'a';
        return hijos[posicion];
    }
    
    @Override
    public int buscar(String unaPalabra) {
        int contador = 0;
        char[] unaPalabraArray = unaPalabra.toCharArray();
        TNodoTrie nodoActual = this;
        for (int c = 0; c < unaPalabraArray.length; c++){
            TNodoTrie unHijo = nodoActual.obtenerHijo(unaPalabraArray[c]);
            if(unHijo == null){
                return contador;
            } else {
                contador += 1;
                nodoActual = unHijo;
            }
        }
        if(nodoActual.esPalabra){
            return contador;
        } else {
            return -1;
        }
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null){
            if (nodo.esPalabra){
                palabras.add(prefijo + s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++){
                if (nodo.hijos[c] != null){
                    predecir(s + (char)(c + 'a'), prefijo, palabras, nodo.hijos[c]);
                }
            }
        }
       
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = buscarNodoTrie(prefijo);
        if (nodo != null){
            predecir("", prefijo, palabras, nodo);
        }
    }

  
}
