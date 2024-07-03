package com.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // LinkedList<TVertice> vertices = new LinkedList<TVertice>();
        // LinkedList<TArista> aristas = new LinkedList<TArista>();

        // TVertice A = new TVertice("A");
        // TVertice B = new TVertice("B");
        // TVertice C = new TVertice("C");
        // TVertice D = new TVertice("D");

        // vertices.add(A);
        // vertices.add(B);
        // vertices.add(C);
        // vertices.add(D);

        // TArista a1 = new TArista(A.getEtiqueta(), B.getEtiqueta(), 1); //AB
        // TArista a5 = new TArista(B.getEtiqueta(), C.getEtiqueta(), 1); //BC
        // TArista a2 = new TArista(B.getEtiqueta(), D.getEtiqueta(), 1); //BD
        // TArista a4 = new TArista(C.getEtiqueta(), A.getEtiqueta(), 1); //CA
        // TArista a6 = new TArista(D.getEtiqueta(), A.getEtiqueta(), 1); //DA
        // TArista a3 = new TArista(D.getEtiqueta(), C.getEtiqueta(), 1); //DC

        // aristas.add(a1);
        // aristas.add(a5);
        // aristas.add(a2);
        // aristas.add(a4);
        // aristas.add(a6);
        // aristas.add(a3);
        
        // TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        // LinkedList<TArista> arcosArbol = new LinkedList<TArista>();
        // LinkedList<TArista> arcosRetroceso = new LinkedList<TArista>();
        // LinkedList<TArista> arcosAvance = new LinkedList<TArista>();
        // LinkedList<TArista> arcosCruzados = new LinkedList<TArista>();
        // grafo.clasificarArcos(A, arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);


        TVertice v1 = new TVertice("A");
        TVertice v2 = new TVertice("B");
        TVertice v3 = new TVertice("C");
        List<TVertice> vertices = Arrays.asList(v1, v2, v3);
        TArista arista1 = new TArista("A", "B", 1.0);
        TArista arista2 = new TArista("B", "C", 2.0);
        TArista arista3 = new TArista("A", "C", 4.0);
        List<TArista> aristas = Arrays.asList(arista1, arista2, arista3);
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        
        // Double[] dj = grafo.dijkstra("A");
        // for (Double d : dj) {
        //     System.out.println(d);
        // }

        TCaminos caminos = grafo.todosLosCaminos("A", "C");
        for(TCamino camino : caminos.getCaminos()){
            System.out.println(camino.imprimirEtiquetas());
        }
         
    }
}
