package com.example;

public class Main {
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB<>();
        Persona p1 = new Persona(1, "Pedro", 1);
        Persona p2 = new Persona(2, "Maria", 2);
        Persona p3 = new Persona(3, "Jose", 3);
        Persona p4 = new Persona(4, "Ana", 4);
        Persona p5 = new Persona(5, "Martin", 5);
        Persona p6 = new Persona(6, "Pepe", 6);
        Persona p7 = new Persona(7, "Juan", 7);
        arbol.insertar(p4.id, p4);
        arbol.insertar(p3.id, p3);
        arbol.insertar(p6.id, p6);
        arbol.insertar(p1.id, p1);
        arbol.insertar(p2.id, p2);
        arbol.insertar(p5.id, p5);
        arbol.insertar(p7.id, p7);

        // System.out.println(arbol.inOrden());
        System.out.println(arbol.encuentraLineal("nombre", "Pedro"));
        System.out.println(arbol.encuentraLineal("nombre", "Ana"));
        System.out.println(arbol.encuentraLineal("nombre", "Fulano"));
        System.out.println(arbol.encuentraLineal("Mengano", "Fulano"));
    }
}