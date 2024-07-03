package com.example;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-
    Collection<TArista> aristas;

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        this.aristas = aristas;
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    public void imprimirListaDeAdyanencias() {
        for (TVertice vertice : vertices.values()) {
            System.out.println("Adyacencias de " + vertice.getEtiqueta());
            LinkedList<TAdyacencia> adyacencias = vertice.getAdyacentes();
            for (TAdyacencia adyacente : adyacencias) {
                System.out.println(adyacente.getEtiqueta());
            }
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     *         contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    // @Override
    // public Comparable centroDelGrafo() {
    //     Double[][] matrizCostos = floyd();
    //     int n = matrizCostos.length;

    //     double minExcentricidad = Double.MAX_VALUE;
    //     Comparable centroGrafo = null;

    //     for (int i = 0; i < n; i++) {
    //         double maxDistancia = Double.MIN_VALUE;
    //         for (int j = 0; j < n; j++) {
    //             if (matrizCostos[i][j] != Double.MAX_VALUE) {
    //                 maxDistancia = Math.max(maxDistancia, matrizCostos[i][j]);
    //             }
    //         }

    //         if (maxDistancia < minExcentricidad) {
    //             minExcentricidad = maxDistancia;
    //             centroGrafo = getEtiquetaVertice(i);
    //         }
    //     }

    //     return centroGrafo;
    // }

    @Override
    public Comparable centroDelGrafo(){
        Comparable minExcentricidad = Double.MAX_VALUE;
        Comparable centroGrafo = null;
        for (TVertice vertice : vertices.values()) {
            Comparable excentricidad = obtenerExcentricidad(vertice.getEtiqueta());
            if(excentricidad.compareTo(minExcentricidad) < 0){
                minExcentricidad = obtenerExcentricidad(vertice.getEtiqueta());
                centroGrafo = vertice.getEtiqueta();
            }
        }
        return centroGrafo;
    }

    private int getIndiceVertice(Comparable etiquetaVertice) {
        Object[] etiquetas = vertices.keySet().toArray();
        for (int i = 0; i < etiquetas.length; i++) {
            if (etiquetas[i].equals(etiquetaVertice)) {
                return i;
            }
        }
        return -1;
    }

    private Comparable getEtiquetaVertice(int indice) {
        Object[] etiquetas = vertices.keySet().toArray();
        return (Comparable) etiquetas[indice];
    }

    @Override
    public Double[][] floyd() {
        int n = vertices.size();
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(vertices);
        Double[][] matrizAux = new Double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAux[i][j] = matriz[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            matrizAux[i][i] = 0.0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrizAux[i][k] != Double.MAX_VALUE && matrizAux[k][j] != Double.MAX_VALUE) {
                        Double suma = matrizAux[i][k] + matrizAux[k][j];
                        if (suma < matrizAux[i][j]) {
                            matrizAux[i][j] = suma;
                        }
                    }
                }
            }
        }

        return matrizAux;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        TVertice vertice = buscarVertice(etiquetaVertice);
        if (vertice == null) {
            return -1; // El vértice no existe en el grafo
        }

        Double[][] matrizCostos = floyd();
        int indiceVertice = getIndiceVertice(etiquetaVertice);

        double maxDistancia = Double.MIN_VALUE;
        for (int i = 0; i < matrizCostos.length; i++) {
            if (matrizCostos[i][indiceVertice] != Double.MAX_VALUE) {
                maxDistancia = Math.max(maxDistancia, matrizCostos[i][indiceVertice]);
            }
        }

        return maxDistancia == Double.MAX_VALUE ? null : maxDistancia;
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Collection<TVertice> bpf() {
        LinkedList<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bpf(visitados);
            }
        }
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        LinkedList<TVertice> visitados = new LinkedList<>();
        // recorro todos desde el primero
        TVertice primero = buscarVertice(etiquetaOrigen);
        primero.bpf(visitados);

        // en caso de que queden vértices sin visitar se recorren
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bpf(visitados);
            }
        }
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        LinkedList<TVertice> visitados = new LinkedList<>();
        // recorro todos desde el primero
        Comparable etiquetaOrigen = vertice.getEtiqueta();
        TVertice primero = buscarVertice(etiquetaOrigen);
        primero.bpf(visitados);

        // en caso de que queden vértices sin visitar se recorren
        for (TVertice v : vertices.values()) {
            if (!v.getVisitado()) {
                v.bpf(visitados);
            }
        }
        return visitados;
    }
    
    @Override
    public Collection<TVertice> bea() {
        LinkedList<TVertice> visitados = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(visitados);
            }
        }
        return visitados;
    }

    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if (v != null) {
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }


    @Override
    public boolean tieneCiclo(TCamino camino) {
        Collection<Comparable> collection = camino.getOtrosVertices();
        LinkedList<Comparable> caminoLL = new LinkedList<>(collection);
        for (TVertice vertice : vertices.values()) {
            if (vertice.tieneCiclo(caminoLL)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        LinkedList<Comparable> camino = new LinkedList<>();
        TVertice primero = buscarVertice(etiquetaOrigen);
        if (primero.tieneCiclo(camino)){
            return true;
        }

        for (TVertice vertice : vertices.values()) {
            if (vertice.tieneCiclo(camino)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean tieneCiclo() {
        LinkedList<Comparable> camino = new LinkedList<>();
        for (TVertice vertice : vertices.values()) {
            if (vertice.tieneCiclo(camino)) {
                return true;
            }
        }
        return false;
    }

    // imprime los vértices accesibles desde v en orden topológico invertido
    public Collection<TVertice> clasificacionTopologica(Comparable verticeOrigen) {
        TVertice vertice = buscarVertice(verticeOrigen);
        Collection<TVertice> verticesAccesibles = new LinkedList<>();
        vertice.clasificacionTopologica(verticesAccesibles);
        return verticesAccesibles;
    }

    public boolean esConexo(){
        boolean esConexo = true;
        LinkedList<Comparable> visitadosBPF1 = new LinkedList<>();
        this.vertices.entrySet().iterator().next().getValue().bpf(visitadosBPF1);
        if (visitadosBPF1.size() != this.vertices.size()){
            esConexo = false;
        }

        TGrafoDirigido grafoInvertido = this.invertirAristas();
        LinkedList<Comparable> visitadosBPF2 = new LinkedList<>();
        grafoInvertido.vertices.entrySet().iterator().next().getValue().bpf(visitadosBPF2);
        if (visitadosBPF2.size() != grafoInvertido.vertices.size()){
            esConexo = false;
        }

        return esConexo;
    }

    public TGrafoDirigido invertirAristas(){
        LinkedList<TArista> aristasInvertidas = new LinkedList<>();
        for (TArista arista : this.aristas){
            TArista aristaNueva = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
            aristasInvertidas.add(aristaNueva);
        }
        LinkedList<TVertice> verticesInvertidos = new LinkedList<>();
        for (TVertice vertice : this.vertices.values()){
            TVertice verticeNueva = new TVertice(vertice.getEtiqueta());
            verticesInvertidos.add(verticeNueva);
        }
        TGrafoDirigido grafo = new TGrafoDirigido(verticesInvertidos, aristasInvertidas);
        return grafo;
    }

}
