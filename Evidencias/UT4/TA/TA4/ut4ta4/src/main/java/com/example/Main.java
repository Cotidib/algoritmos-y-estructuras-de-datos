package com.example;

public class Main {
    public static void main(String[] args) {
        TArbolBB arbol1 = new TArbolBB<>();
        arbol1.insertar("T", "T");
        arbol1.insertar("Y", "Y");
        arbol1.insertar("U", "U");
        arbol1.insertar("P", "P");
        arbol1.insertar("L", "L");
        arbol1.insertar("K", "K");
        arbol1.insertar("J", "J");
        arbol1.insertar("S", "S");
        arbol1.insertar("A", "A");
        arbol1.insertar("Z", "Z");
        arbol1.insertar("X", "X");
        arbol1.insertar("C", "C");
        arbol1.insertar("V", "V");
        arbol1.insertar("N", "N");

        System.out.println("Contar Hojas: " + arbol1.contarHojas());
        System.out.println("Obtener Nivel de C: " + arbol1.obtenerNivel("C"));
    }
}