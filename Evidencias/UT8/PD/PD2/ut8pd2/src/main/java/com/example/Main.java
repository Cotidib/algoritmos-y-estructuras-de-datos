package com.example;

import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();

        TVertice v1 = new TVertice(1);
        TVertice v2 = new TVertice(2);
        TVertice v3 = new TVertice(3);
        TVertice v4 = new TVertice(4);
        TVertice v5 = new TVertice(5);
        TVertice v6 = new TVertice(6);

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);
        vertices.add(v6);

        TArista a1 = new TArista(1,2,6);
        TArista a2 = new TArista(1,3,1);
        TArista a3 = new TArista(1,4,5);
        TArista a4 = new TArista(2,3,5);
        TArista a5 = new TArista(3,4,5);
        TArista a9 = new TArista(3,6,4);
        TArista a6 = new TArista(5,2,3);
        TArista a7 = new TArista(5,6,6);
        TArista a8 = new TArista(5,3,6);
        TArista a10 = new TArista(6,4,2);

        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        aristas.add(a9);
        aristas.add(a10);

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        System.out.println("Kruskal");
        TGrafoNoDirigido kruskal = grafo.Kruskal();
        for (TArista arista : kruskal.lasAristas) {
            System.out.println(arista.getEtiquetaOrigen() + " " + arista.getEtiquetaDestino() + " " + arista.getCosto());
        }
        
        TGrafoNoDirigido prim = grafo.Prim();
        System.out.println("Prim");
        for (TArista arista : prim.lasAristas) {
            System.out.println(arista.getEtiquetaOrigen() + " " + arista.getEtiquetaDestino() + " " + arista.getCosto());
        }
    }
}
