package com.example;

import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<TVertice> vertices = new LinkedList<TVertice>();
        LinkedList<TArista> aristas = new LinkedList<TArista>();

        TVertice v1 = new TVertice(1);
        TVertice v2 = new TVertice(2);
        TVertice v3 = new TVertice(3);
        TVertice v4 = new TVertice(4);

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);

        TArista a1 = new TArista(v1.getEtiqueta(), v2.getEtiqueta(), 1);
        TArista a2 = new TArista(v2.getEtiqueta(), v3.getEtiqueta(), 2);
        TArista a3 = new TArista(v3.getEtiqueta(), v4.getEtiqueta(), 3);
        TArista a4 = new TArista(v4.getEtiqueta(), v1.getEtiqueta(), 4);

        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);
        System.out.println("Tiene ciclo: " + grafo.tieneCiclo());
        
        Collection<TVertice> clasificacion = grafo.clasificacionTopologica(1);
        for (TVertice vertice : clasificacion) {
            System.out.println(vertice.getEtiqueta());
        }
            
        aristas.add(a4);
        System.out.println("Es conexo: " + grafo.esConexo());
    }
}
