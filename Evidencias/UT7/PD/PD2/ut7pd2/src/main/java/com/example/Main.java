package com.example;

import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        
        TVertice artigas = new TVertice("Artigas");
        TVertice canelones = new TVertice("Canelones");
        TVertice durazno = new TVertice("Durazno");
        TVertice florida = new TVertice("Florida");
        TVertice montevideo = new TVertice("Montevideo");
        TVertice pde = new TVertice("Punta del Este");
        TVertice rocha = new TVertice("Rocha");
        TVertice colonia = new TVertice("Colonia");

        LinkedList<TVertice> vertices = new LinkedList<TVertice>();
        vertices.add(artigas);
        vertices.add(canelones);
        vertices.add(durazno);
        vertices.add(florida);
        vertices.add(montevideo);
        vertices.add(pde);
        vertices.add(rocha);

        TArista a1 = new TArista(artigas.getEtiqueta(), rocha.getEtiqueta(), 400);
        TArista a2 = new TArista(canelones.getEtiqueta(), artigas.getEtiqueta(), 500);
        TArista a3 = new TArista(canelones.getEtiqueta(), durazno.getEtiqueta(), 170);
        TArista a4 = new TArista(canelones.getEtiqueta(), pde.getEtiqueta(), 90);
        TArista a5 = new TArista(canelones.getEtiqueta(), colonia.getEtiqueta(), 200);
        TArista a6 = new TArista(colonia.getEtiqueta(), montevideo.getEtiqueta(), 180);
        TArista a7 = new TArista(florida.getEtiqueta(), durazno.getEtiqueta(), 60);
        TArista a8 = new TArista(montevideo.getEtiqueta(), artigas.getEtiqueta(), 700);
        TArista a9 = new TArista(montevideo.getEtiqueta(), canelones.getEtiqueta(), 30);
        TArista a10 = new TArista(montevideo.getEtiqueta(), pde.getEtiqueta(), 130);
        TArista a11 = new TArista(pde.getEtiqueta(), rocha.getEtiqueta(), 90);
        TArista a12 = new TArista(rocha.getEtiqueta(), montevideo.getEtiqueta(), 270);

        LinkedList<TArista> aristas = new LinkedList<TArista>();
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
        aristas.add(a11);
        aristas.add(a12);

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        Comparable[][] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafo.getVertices(), "Matriz de adyacencia");

        Comparable[][] floyd = grafo.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafo.getVertices(), "Floyd");

        System.out.println("Excentricidad Montevideo: " + grafo.obtenerExcentricidad("Montevideo"));
        System.out.println("Centro del Grafo: " + grafo.centroDelGrafo());
    }
}
