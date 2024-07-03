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

        TArista a1 = new TArista(1,2,5);
        TArista a2 = new TArista(1,3,7);
        TArista a3 = new TArista(1,4,3);
        TArista a4 = new TArista(1,5,9);
        TArista a5 = new TArista(1,6,4);
        TArista a6 = new TArista(2,3,3);
        TArista a7 = new TArista(2,4,5);
        TArista a8 = new TArista(2,5,7);
        TArista a10 = new TArista(2,6,8);
        TArista a11 = new TArista(3,4,4);
        TArista a12 = new TArista(3,5,5);
        TArista a13 = new TArista(3,6,7);
        TArista a14 = new TArista(4,5,9);
        TArista a15 = new TArista(4,6,3);
        TArista a16 = new TArista(5,6,6);

        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        aristas.add(a10);
        aristas.add(a11);
        aristas.add(a12);
        aristas.add(a13);
        aristas.add(a14);
        aristas.add(a15);
        aristas.add(a16);

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);
        TGrafoNoDirigido prim = grafo.Prim();
        System.out.println("Prim");
        for (TArista arista : prim.lasAristas) {
            System.out.println(arista.getEtiquetaOrigen() + " " + arista.getEtiquetaDestino() + " " + arista.getCosto());
        }

        // System.out.println("Kruskal");
        // TGrafoNoDirigido kruskal = grafo.Kruskal();
        // for (TArista arista : kruskal.lasAristas) {
        //     System.out.println(arista.getEtiquetaOrigen() + " " + arista.getEtiquetaDestino() + " " + arista.getCosto());
        // }

    }
}
