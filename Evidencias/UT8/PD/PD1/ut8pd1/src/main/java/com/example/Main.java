package com.example;

import java.util.Collection;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        TVertice va = new TVertice("a");
        TVertice vb = new TVertice("b");
        TVertice vd = new TVertice("d");
        TVertice ve = new TVertice("e");
        TVertice vc = new TVertice("c");
        TVertice vf = new TVertice("f");
        TVertice vg = new TVertice("g");

        Collection<TVertice> vertices = new LinkedList<>();
        vertices.add(va);
        vertices.add(vb);
        vertices.add(vd);
        vertices.add(ve);
        vertices.add(vc);
        vertices.add(vf);

        TArista ab = new TArista(va.getEtiqueta(), vb.getEtiqueta(), 6);
        TArista ac = new TArista(va.getEtiqueta(), vc.getEtiqueta(), 1);
        TArista ad = new TArista(va.getEtiqueta(), vd.getEtiqueta(), 5);
        TArista bc = new TArista(vb.getEtiqueta(), vc.getEtiqueta(), 5);
        TArista be = new TArista(vb.getEtiqueta(), ve.getEtiqueta(), 3);
        TArista cd = new TArista(vc.getEtiqueta(), vd.getEtiqueta(), 5);
        TArista ce = new TArista(vc.getEtiqueta(), ve.getEtiqueta(), 6);
        TArista cf = new TArista(vc.getEtiqueta(), vf.getEtiqueta(), 4);
        TArista ef = new TArista(ve.getEtiqueta(), vf.getEtiqueta(), 6);
        TArista fd = new TArista(vd.getEtiqueta(), vf.getEtiqueta(), 2);

        Collection<TArista> aristas = new LinkedList<>();
        aristas.add(ab);
        aristas.add(ac);
        aristas.add(ad);
        aristas.add(bc);
        aristas.add(be);
        aristas.add(cd);
        aristas.add(ce);
        aristas.add(cf);
        aristas.add(ef);
        aristas.add(fd);

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        // Adyacentes
        // grafo.imprimirListaDeAdyanencias();
        
        // Caminos a-e
        // TCaminos todosLosCaminos = grafo.todosLosCaminos("a", "e");
        // System.out.println(todosLosCaminos.imprimirCaminos());

        System.out.println("PRIM:");
        System.out.println("Cantidad de aristas original: " + grafo.getLasAristas().size());
        TGrafoNoDirigido prim = grafo.Prim();
        System.out.println("Cantidad de aristas del AAM: " + prim.getLasAristas().size());
        prim.imprimirListaDeAdyanencias();

        System.out.println("BPF:");
        Collection<TVertice> visitadosBPF = grafo.bpf();
        for (TVertice vertice : visitadosBPF) {
            System.out.println(vertice.getEtiqueta());
        }
        System.out.println("BEA:");
        Collection<TVertice> visitadosBEA = grafo.bea();
        for (TVertice vertice : visitadosBEA) {
            System.out.println(vertice.getEtiqueta());
        }

    }
}
