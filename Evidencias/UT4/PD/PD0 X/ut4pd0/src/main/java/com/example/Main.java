package com.example;

public class Main {
    public static void main(String[] args) {
        TArbolEA arbol1 = new TArbolEA<>();
        String expresion = "+x2-a1x3b"; //2 x (a - 1) + 3 x b
        String[] expresionArray = expresion.split("");
        Cola expresionQueue = new Cola();
        for (String caracter : expresionArray){
            Nodo nodo = new Nodo(caracter, caracter);
            expresionQueue.push(nodo);
        }
        arbol1.inicializar(expresionQueue);
        System.out.println(arbol1.inOrden());
        arbol1.reemplazar("a", 5);
        System.out.println(arbol1.inOrden());
        arbol1.reemplazar("b", 7);
        System.out.println(arbol1.inOrden());  
        System.out.println(arbol1.evaluar());      

        TArbolEA arbol2 = new TArbolEA<>();
        String expresion1 = "+1-x5c/d2"; //1 + (5 * c) - (d / 2)
        String[] expresionArra2 = expresion1.split("");
        Cola expresionQueue2 = new Cola();
        for (String caracter : expresionArra2){
            Nodo nodo = new Nodo(caracter, caracter);
            expresionQueue2.push(nodo);
        }
        arbol2.inicializar(expresionQueue2);
        System.out.println(arbol2.inOrden());
        arbol2.reemplazar("c", 5);
        System.out.println(arbol2.inOrden());
        arbol2.reemplazar("d", 10);
        System.out.println(arbol2.inOrden());  
        System.out.println(arbol2.evaluar());   

    }
}