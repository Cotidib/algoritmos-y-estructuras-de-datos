package com.example;


import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    public int numeroBP;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }


    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }


    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

  
    @Override
    public void bpf(Collection<TVertice> visitados) {
        if (!visitados.contains(this)) {
            visitados.add(this);
            for (TAdyacencia adyacencia : adyacentes) {
                adyacencia.getDestino().bpf(visitados);
            }
        }
    }

    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, copia, todosLosCaminos);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }


    @Override
    public void bea(Collection<TVertice> visitados) {
        Queue<TVertice> vertices = new LinkedList<TVertice>();
        String tempStr = "";

        this.setVisitado(true);
        vertices.add(this);
        tempStr += this.getEtiqueta().toString();
        visitados.add(this);

        while (vertices.size() > 0) {
            TVertice vertice = vertices.remove();
            LinkedList<TAdyacencia> adyacentes = vertice.getAdyacentes();
            for (TAdyacencia adyacencia : adyacentes) {
                TVertice destino = adyacencia.getDestino();
                if (!destino.getVisitado()) {
                    destino.setVisitado(true);
                    vertices.add(destino);
                    tempStr += " " + destino.getEtiqueta().toString();
                    visitados.add(destino);
                }
            }
        }
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        if (camino.contains(this.getEtiqueta())) {
            return true;
        }

        camino.add(this.etiqueta);

        for (TAdyacencia adyacencia : adyacentes) {
            if(adyacencia.getDestino().tieneCiclo(camino)){
                return true;
            }
        } 

        camino.remove(this.etiqueta);
        return false;
    }

    public void clasificacionTopologica(Collection<TVertice> visitados) {
        for (TAdyacencia adyacencia : adyacentes) {
            if(!visitados.contains(adyacencia.getDestino())){
                adyacencia.getDestino().clasificacionTopologica(visitados);
            }
        }
        visitados.add(this);
    }


    public void obtenerNumeroBP(Collection<TVertice> visitados) {
        if (!visitados.contains(this)) {
            this.numeroBP = visitados.size() + 1;
            this.setVisitado(true);
            visitados.add(this);
            for (TAdyacencia adyacencia : adyacentes) {
                adyacencia.getDestino().obtenerNumeroBP(visitados);
            }
        }
    }

    public void clasificarArcos(LinkedList<TArista> arcosArbol, LinkedList<TArista> arcosRetroceso, LinkedList<TArista> arcosAvance, LinkedList<TArista> arcosCruzados){
        for (TAdyacencia adyacencia : adyacentes) {
            TVertice destino = adyacencia.getDestino();
            TArista arista = new TArista(this.getEtiqueta(), destino.getEtiqueta(), adyacencia.getCosto());
            if(this.numeroBP < destino.numeroBP){
                if(destino.getVisitado()){
                    arcosAvance.add(arista);
                } else {
                    arcosArbol.add(arista);
                }
            } else if(this.numeroBP > destino.numeroBP){
               if(destino.esAncestro(this)){
                    arcosRetroceso.add(arista);
               } else {
                    arcosCruzados.add(arista);
               }
            }
            destino.setVisitado(true);
        }
    }

    public boolean esAncestro(TVertice vertice){
        boolean esAncestro1 =  this.numeroBP < vertice.numeroBP;
        boolean esAncestro2 =  vertice.numeroBP <= this.numeroBP + this.getDescendientes();
        return esAncestro1 && esAncestro2;
    }

    public int getDescendientes() {
        Set<TVertice> descendientes = new HashSet<>();
        obtenerDescendientes(descendientes);
        return descendientes.size();
    }

    private void obtenerDescendientes(Set<TVertice> descendientes) {
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!descendientes.contains(destino) && destino.numeroBP > this.numeroBP) {
                descendientes.add(destino);
                destino.obtenerDescendientes(descendientes);
            }
        }
    }

   

}
