package com.example;

public class Main {
    public static void main(String[] args) {
        Nodo nodo1 = new Nodo(1, 1);
        Nodo nodo2 = new Nodo(2, 2);
        Nodo nodo3 = new Nodo(3, 3);
        Nodo nodo4 = new Nodo(4, 4);
        Nodo nodo5 = new Nodo(5, 5);
        Nodo nodo6 = new Nodo(6, 6);
        Nodo nodo7 = new Nodo(7, 7);
        Nodo nodo8 = new Nodo(8, 8);
        Nodo nodo71 = new Nodo(71, 71);
        Nodo nodo12 = new Nodo(12, 12);
        Nodo nodo35 = new Nodo(35, 35);
        Nodo nodo11 = new Nodo(11, 11);
        Nodo nodo22 = new Nodo(22, 22);
        Nodo nodo17 = new Nodo(17, 17);

        Lista lista = new Lista<>();
        lista.insertar(nodo4);
        lista.insertar(nodo71);
        lista.insertar(nodo3);
        lista.insertar(nodo6);
        lista.insertar(nodo12);
        lista.insertar(nodo8);
        lista.insertar(nodo35);
        lista.insertar(nodo11);
        lista.insertar(nodo22);
        lista.insertar(nodo17);
        lista.eliminar(17);

        System.out.println("Original: " + lista.imprimir(" "));
        // lista.ordenar();
        // System.out.println("Ordenada: " + lista.imprimir(" "));
        
        // Lista lista2 = lista.ordenaImparesPares();
        // System.out.println("Orden Impar-Par: " + lista2.imprimir(" "));

    }
}