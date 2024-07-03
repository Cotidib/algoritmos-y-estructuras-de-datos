package com.example;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
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
    protected TVertice buscarVertice(Comparable unaEtiqueta) {
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
    public Comparable centroDelGrafo() {
        Comparable res = null;
        Double minExc = Double.MAX_VALUE;
        for (Comparable vert : vertices.keySet()){
            Double exc = obtenerExcentricidad(vert);
            if (exc < minExc && exc != -1){
                res = vert;
                minExc = exc;
            }
        }
        return res;
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

    public Double[] dijkstra(Comparable verticeOrigen) {
        HashSet<Comparable> S = new HashSet<>();
        Double[] D = new Double[vertices.size()]; // Arreglo con las distancias desde el origen
        Arrays.fill(D, Double.MAX_VALUE); // Inicializar todas las distancias con infinito
        TVertice origen = vertices.get(verticeOrigen);


        int indiceOrigen = getIndiceVertice(verticeOrigen);
        D[indiceOrigen] = 0.0; // La distancia del origen a sí mismo es 0

        PriorityQueue<TVertice> colaPrioridad = new PriorityQueue<>((v1, v2) -> 
            Double.compare(D[getIndiceVertice(v1.getEtiqueta())], D[getIndiceVertice(v2.getEtiqueta())]));
        colaPrioridad.offer(origen);

        while (!colaPrioridad.isEmpty()) {
            TVertice u = colaPrioridad.poll();
            int indiceU = getIndiceVertice(u.getEtiqueta());
            S.add(u.getEtiqueta());

            for (Object o : u.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) o;
                TVertice v = ady.getDestino();
                int indiceV = getIndiceVertice(v.getEtiqueta());

                if (!S.contains(v.getEtiqueta())) {
                    double distanciaActual = D[indiceV];
                    double nuevaDistancia = D[indiceU] + ady.getCosto();

                    if (nuevaDistancia < distanciaActual) {
                        D[indiceV] = nuevaDistancia;
                        colaPrioridad.offer(v);
                    }
                }
            }
        }

        return D;
    }
    
    // @Override
    // public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
    //     Double[][] matriz = this.floyd();
    //     Set<Comparable> etiquetasVertices = this.vertices.keySet();
    //     Comparable[] array = new Comparable[matriz.length];
    //     array = etiquetasVertices.toArray(array);
    //     int columna = 0;
    //     for (int i = 0; i < array.length; i++) {
    //         if(array[i] == etiquetaVertice){
    //             columna = i;
    //             break;
    //         }
    //     }
    //     Double ex = 0.0;
    //     for (int i =0; i<matriz.length; i++){
    //         if(matriz[i][columna]>ex && matriz[i][columna]<Double.MAX_VALUE && matriz[i][columna]>0.0){
    //             ex = matriz[i][columna];
    //         }
    //     }
    //     if (ex == 0.0){
    //         ex = Double.MAX_VALUE;
    //     }
    //     return ex;
    // }

    @Override
    public Double obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] aux = this.floyd();
        int index = 0;
        for (Comparable vert : vertices.keySet()){
            if(vert.equals(etiquetaVertice)){
                break;
            }
            index++;
        }

        Double valMax = 0.0;
        for(int i = 0; i < vertices.keySet().size(); i++){
            if (aux[i][index] != Double.MAX_VALUE && aux[i][index] > valMax){
                valMax = aux[i][index];
            }
        }
        if (valMax == 0){
            return -1.0;
        }else{
            return valMax;
        }
    }

    @Override
    public boolean[][] warshall() {
        int n = vertices.size();
        boolean[][] A = new boolean[n][n];
        Double[][] C = UtilGrafos.obtenerMatrizCostos(vertices);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (C[i][j] != Double.MAX_VALUE)
                    A[i][j] = true;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (!A[i][k])
                    continue;
                for (int j = 0; j < n; j++) {
                    if (!A[i][j]) {
                        A[i][j] = A[i][k] && A[k][j];
                    }
                }
            }
        }
        return A;
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        TVertice verticeEliminar = vertices.get(nombreVertice);
        if (verticeEliminar == null)
            return false;

        // elimino las adyacencias al vértice eliminado
        for (Map.Entry<Comparable, TVertice> v : vertices.entrySet()) {
            TVertice vertice = v.getValue();
            vertice.eliminarAdyacencia(nombreVertice);
        }

        // elimino el vertice del grafo
        return vertices.remove(nombreVertice, verticeEliminar);
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

    public void clasificarArcos(TVertice verticeOrigen, LinkedList<TArista> arcosArbol, LinkedList<TArista> arcosRetroceso, LinkedList<TArista> arcosAvance, LinkedList<TArista> arcosCruzados){
        LinkedList<TVertice> visitados = new LinkedList<>();
        buscarVertice(verticeOrigen.getEtiqueta()).obtenerNumeroBP(visitados);

        for (TVertice vertice : vertices.values()) {
            if (!visitados.contains(vertice)) {
                vertice.obtenerNumeroBP(visitados);
            }
        }

        for (int i=visitados.size()-1; i>=0; i--){
            visitados.get(i).clasificarArcos(arcosArbol, arcosRetroceso, arcosAvance, arcosCruzados);
        }

    }

}
