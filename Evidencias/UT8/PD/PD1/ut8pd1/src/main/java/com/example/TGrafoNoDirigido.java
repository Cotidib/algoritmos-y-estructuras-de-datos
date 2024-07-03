package com.example;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
    protected TAristas lasAristas = new TAristas() ;
       /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
       super(vertices, aristas);     
      lasAristas.insertarAmbosSentidos(aristas);
       
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
            return lasAristas;
        }

    @Override
    public TGrafoNoDirigido Prim() {
        LinkedList<Comparable> visitados = new LinkedList<>();
        LinkedList<Comparable> vertices = new LinkedList<>();
        for (Map.Entry<Comparable, TVertice> tVertice : this.getVertices().entrySet()) {
            vertices.add(tVertice.getValue().getEtiqueta());
        }
            
        LinkedList<TArista> aristasAAM = new LinkedList<>();
        LinkedList<TVertice> verticesAAM = new LinkedList<>();

        verticesAAM.add(this.getVertices().get(vertices.get(0)));
        visitados.add(vertices.get(0));
        vertices.remove(0);

        while (!vertices.isEmpty()) {
            TArista tempArista = this.lasAristas.buscarMin(visitados, vertices);
            aristasAAM.add(tempArista);
            verticesAAM.add(this.getVertices().get(tempArista.getEtiquetaDestino()));

            visitados.add(tempArista.getEtiquetaDestino());
            vertices.remove(tempArista.getEtiquetaDestino());
        }

        return new TGrafoNoDirigido(verticesAAM, aristasAAM);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        LinkedList<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : this.getVertices().values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(visitados);
            }
        }
        return visitados;
    }
}
