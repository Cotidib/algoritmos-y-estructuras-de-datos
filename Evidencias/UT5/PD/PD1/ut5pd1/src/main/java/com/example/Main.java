package com.example;

public class Main {
    public static void main(String[] args) {
        TArbolGenerico<String> arbol = new TArbolGenerico<>();
        
        // insertar la raiz
        arbol.insertar("R", "");
        
        // arbol.insertar("VICERRECTORÍA DEL MEDIO UNIVERSITARIO", "RECTORÍA");
        // arbol.insertar("VICERRECTORÍA ACADÉMICA", "RECTORÍA");
        // arbol.insertar("VICERRECTORÍA ADMINISTRATIVA", "RECTORÍA");
        // arbol.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORÍA ACADÉMICA");
        // arbol.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORÍA ACADÉMICA");
        // arbol.insertar("FACULTAD DE INGENIERÍA Y TECNOLOGÍAS", "VICERRECTORÍA ACADÉMICA");
        // arbol.insertar("FACULTAD DE PSICOLOGÍA", "VICERRECTORÍA ACADÉMICA");
        // arbol.insertar("DEPARTAMENTO DE INFORMÁTICA Y CIENCIAS DE LA COMPUTACIÓN", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        // arbol.insertar("DEPARTAMENTO DE INGENIERÍA ELÉCTRICA", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        // arbol.insertar("DEPARTAMENTO DE MATEMÁTICAS", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        
        // insertar hijos y hermanos
        arbol.insertar("VMU", "R");
        arbol.insertar("VA", "R");
        arbol.insertar("VA", "R");
        arbol.insertar("FCE", "VA");
        arbol.insertar("FCH", "VA");
        arbol.insertar("FIT", "VA");
        arbol.insertar("FP", "VA");
        arbol.insertar("DICC", "FIT");
        arbol.insertar("DIE", "FIT");
        arbol.insertar("DM", "FIT");
       
        // imprimir arbol
        arbol.listarIndentado();

        //buscar
        TNodoArbolGenerico buscado = arbol.buscar("VA");
        TNodoArbolGenerico buscado2 = arbol.buscar("DICC");
        TNodoArbolGenerico buscado3 = arbol.buscar("X");
        System.out.println(buscado);
        System.out.println(buscado2);
        System.out.println(buscado3);

    }
}