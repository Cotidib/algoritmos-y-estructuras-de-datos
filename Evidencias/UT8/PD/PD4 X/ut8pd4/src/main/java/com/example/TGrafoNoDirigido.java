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
        // - setup
        Collection<TArista> aristasAAM = new LinkedList<>();
        LinkedList<TVertice> verticesAAM = new LinkedList<>();
        for (TVertice vertice : this.getVertices().values()) {
            verticesAAM.add(new TVertice(vertice.getEtiqueta()));
        }
        TGrafoNoDirigido nuevoGrafo = new TGrafoNoDirigido(verticesAAM, aristasAAM);
        Collection<TArista> aristasAux = new LinkedList<>();
        for(TArista arista : this.getLasAristas()){
            aristasAux.add(arista);
        }
        // - setup end
        
        int verticesConectados = 0;
        while (verticesConectados < nuevoGrafo.getVertices().size()) {
            // examinar aristas en orden creciente de costo (obteniendo siempre la menor)
            TArista minArista = null;
            double minCosto = Double.MAX_VALUE;
            for(TArista arista : aristasAux){
                if(arista.getCosto() < minCosto){
                    minCosto  = arista.getCosto();
                    minArista = arista;
                }
            }

            if (minArista != null){
                Comparable origen = minArista.getEtiquetaOrigen();
                Comparable destino = minArista.getEtiquetaDestino();
                // si no existe camino entre origen y destino, se agrega arista a AAM, sino se descarta
                TCaminos caminos = nuevoGrafo.todosLosCaminos(origen, destino);
                if (caminos.getCaminos().isEmpty()){
                    nuevoGrafo.insertarArista(minArista);
                    nuevoGrafo.insertarArista(minArista.aristaInversa());
                    nuevoGrafo.getLasAristas().add(minArista);
                    nuevoGrafo.getLasAristas().add(minArista.aristaInversa());
                } else {
                    aristasAux.remove(minArista);
                }
            }

            // obtener cantidad de vertices conectados hasta el momento, desde el primero (BPF)
            TVertice primero = nuevoGrafo.getVertices().values().iterator().next();
            LinkedList<TVertice> visitados = new LinkedList<>();
            primero.bpf(visitados);
            verticesConectados = visitados.size();
        }
        return nuevoGrafo;
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

    public boolean conectados(TVertice v, TVertice w){
        LinkedList<TVertice> visitados = new LinkedList<>();
        v.bpf(visitados);
        for (TVertice vertice : visitados) {
            if (vertice.getEtiqueta().equals(w.getEtiqueta())) {
                return true;
            }
        }
        return false;

    }
}
