package com.example;

public class Main {
    public static void main(String[] args) {
        TArbolBB arbol2 = new TArbolBB<>();
        arbol2.insertar(12, 12);
        arbol2.insertar(25, 25);
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

        System.out.println("Inorden: " + arbol2.inOrden());
        System.out.println("Preorden: " + arbol2.preOrden());
        System.out.println("Postorden: " + arbol2.postOrden());

        System.out.println("Eliminacion:");
        arbol2.eliminar(99);
        arbol2.eliminar(15);
        arbol2.eliminar(2);
        System.out.println("Inorden: " + arbol2.inOrden());
        arbol2.eliminar(12);
        System.out.println("Inorden: " + arbol2.inOrden());
        arbol2.eliminar(77);
        arbol2.eliminar(33);
        System.out.println("Inorden: " + arbol2.inOrden());
        System.out.println("Preorden: " + arbol2.preOrden());
        System.out.println("Postorden: " + arbol2.postOrden());
    }
}