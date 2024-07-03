


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

public class TGrafoNoDirigido extends TGrafoDirigido {
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
