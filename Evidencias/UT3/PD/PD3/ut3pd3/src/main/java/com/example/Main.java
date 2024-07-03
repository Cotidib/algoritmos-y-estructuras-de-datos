package com.example;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista<>();

        Nodo nodo1 = new Nodo<>("nodo1", 1);
        Nodo nodo2 = new Nodo<>("nodo2", 2);
        Nodo nodo3 = new Nodo<>("nodo3", 3);
        Nodo nodo4 = new Nodo<>("nodo4", 4);
        
        lista.setPrimero(nodo1);
        lista.insertar(nodo2);
        lista.insertar(nodo3);
        lista.insertar(nodo4);
        System.out.println(lista.imprimir("\n"));
        System.out.println(lista.cantElementos());

        System.out.println(lista.buscar("nodo3").getEtiqueta());

        lista.eliminar("nodo2");
        System.out.println(lista.imprimir("\n"));
        System.out.println(lista.cantElementos());
    }
}