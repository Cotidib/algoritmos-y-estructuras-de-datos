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

        System.out.println("Altura: " + arbol1.obtenerAltura());
        System.out.println(arbol1.inOrden());

        TArbolBB arbol2 = new TArbolBB<>();
        arbol2.insertar(12, 12);
        arbol2.insertar(55, 55);
        arbol2.insertar(14, 14);
        arbol2.insertar(1, 1);
        arbol2.insertar(33, 33);
        arbol2.insertar(88, 88);
        arbol2.insertar(45, 45);
        arbol2.insertar(2, 2);
        arbol2.insertar(7, 7);
        arbol2.insertar(66, 66);
        arbol2.insertar(5, 5);
        arbol2.insertar(99, 99);

        System.out.println("Preorden: " + arbol2.preOrden());
        System.out.println("Postorden: " + arbol2.postOrden());
        System.out.println("Inorden: " + arbol2.inOrden());

        System.out.println("Eliminacion:");
        arbol2.eliminar(99);
        System.out.println(arbol2.inOrden());
        arbol2.eliminar(2);
        System.out.println(arbol2.inOrden());
        arbol2.eliminar(12);
        System.out.println(arbol2.inOrden());
        arbol2.eliminar(33);
        System.out.println("Inorden: " + arbol2.inOrden());
        System.out.println("Preorden: " + arbol2.preOrden());
        System.out.println("Postorden: " + arbol2.postOrden());
    }
}