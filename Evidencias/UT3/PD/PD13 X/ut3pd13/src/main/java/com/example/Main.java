package com.example;

public class Main {
    public static void main(String[] args) {
        Nodo nodo1 = new Nodo(1, 1);
        Nodo nodo2 = new Nodo(2, 2);
        Nodo nodo3 = new Nodo(3, 3);
        Nodo nodo4 = new Nodo(4, 4);
        Nodo nodo5 = new Nodo(5, 5);
        Nodo nodo6 = new Nodo(6, 6);

        Cola cola = new Cola<>();
        cola.insertar(nodo1);
        System.out.println(cola.imprimir(" "));
        cola.insertar(nodo2);
        cola.insertar(nodo3);
        cola.insertar(nodo4);
        cola.insertar(nodo5);
        cola.insertar(nodo6);
        System.out.println(cola.imprimir(" "));
        cola.retirar();
        System.out.println(cola.imprimir(" "));
        cola.retirar();
        System.out.println(cola.imprimir(" "));
        cola.retirar();
        System.out.println(cola.imprimir(" "));
        cola.retirar();
        System.out.println(cola.imprimir(" "));

    }
}